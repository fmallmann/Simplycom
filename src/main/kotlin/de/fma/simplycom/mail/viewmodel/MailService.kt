package de.fma.simplycom.mail.viewmodel

import de.fma.simplycom.board.viewmodel.MailPropertiesEntity
import de.fma.simplycom.board.viewmodel.MailRepository
import tornadofx.Controller
import java.util.Properties
import javax.mail.Folder


class MailService : Controller() {

    val mailRepository: MailRepository by inject()

    fun sendMail(receiver: String, subject: String, body: String) {
        val mailPropertiesEntity = mailRepository.load()
        if (mailPropertiesEntity != null) {
            connect(getConnectionInformation(mailPropertiesEntity), convertProperties(mailPropertiesEntity)) {
                val message = send {
                    from(mailPropertiesEntity.username, mailPropertiesEntity.shownName)
                    to(receiver)
                    subject(subject)
                    text(body)
                }
                folder("Sent Items", Folder.READ_WRITE) {
                    save(message)
                }
            }
        }
    }

    private fun convertProperties(mailPropertiesEntity: MailPropertiesEntity): Properties {
        val properties = Properties()
        properties["mail.smtp.auth"] = "true"
        properties["mail.smtp.starttls.enable"] = "true"
        properties["mail.smtp.host"] = mailPropertiesEntity.smtpHostname
        properties["mail.smtp.port"] = mailPropertiesEntity.smtpPort
        properties["mail.imap.ssl.enable"] = if (mailPropertiesEntity.enableSsl) "true" else "false"
        return properties
    }

    fun receiveMails(): MutableList<MailInfo> {
        val mailPropertiesEntity = mailRepository.load()
        return if (mailPropertiesEntity != null) {
            var mailInfos = mutableListOf<MailInfo>()
            val mailProperties = convertProperties(mailPropertiesEntity)
            val connectionInformation = getConnectionInformation(mailPropertiesEntity)
            connect(connectionInformation, mailProperties) {
                folder("INBOX") {
                    mailInfos = readAll().map { it.mailInfo }.toMutableList()
                }
            }
            mailInfos
        } else {
            mutableListOf()
        }
    }

    private fun getConnectionInformation(mailPropertiesEntity: MailPropertiesEntity): ConnectionInformation {
        return ConnectionInformation(
                mailPropertiesEntity.imapHostname,
                mailPropertiesEntity.imapPort,
                mailPropertiesEntity.username,
                mailPropertiesEntity.password
        )
    }
}
