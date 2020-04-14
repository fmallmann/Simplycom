package de.fma.simplycom.mail.viewmodel

import com.sun.mail.imap.IMAPFolder
import de.fma.simplycom.board.viewmodel.MailPropertiesEntity
import de.fma.simplycom.board.viewmodel.MailRepository
import tornadofx.Controller
import java.io.Closeable
import java.util.Date
import java.util.Properties
import javax.mail.Folder
import javax.mail.Message
import javax.mail.Session
import javax.mail.Store
import javax.mail.internet.InternetAddress

class MailService : Controller() {

    val mailRepository: MailRepository by inject()

    fun sendMail(subject: String, body: String) {

    }

    fun receiveMails(): MutableList<MailInfo> {
        var mailInfos = mutableListOf<MailInfo>()
        val mailPropertiesEntity = mailRepository.load()
        return if (mailPropertiesEntity != null) {
            val mailProperties = getMailProperties(mailPropertiesEntity)
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
                mailPropertiesEntity.port,
                mailPropertiesEntity.username,
                mailPropertiesEntity.password
        )
    }

    private fun getMailProperties(mailPropertiesEntity: MailPropertiesEntity): Properties {
        val mailProperties = Properties()
        if (mailPropertiesEntity.enableSsl) {
            mailProperties.setProperty("mail.imap.ssl.enable", "true")
        }
        return mailProperties
    }
}

fun connect(connectionInformation: ConnectionInformation, props: Properties = Properties(), action: Imap.() -> Unit) {
    val session = Session.getInstance(props)
    val store = session.getStore("imap")
    store.connect(connectionInformation)
    Imap(store).use {
        it.action()
    }
}

data class ConnectionInformation(
        val host: String,
        val port: Int,
        val user: String,
        val password: String)

class Imap internal constructor(private val store: Store) : Closeable, AutoCloseable {
    override fun close() {
        store.close()
    }

    fun folder(name: String, action: MailFolder.() -> Unit) {
        val imapFolder = store.getFolder(name) as IMAPFolder
        imapFolder.open(Folder.READ_ONLY)
        val mailFolder = MailFolder(imapFolder)
        mailFolder.action()
        imapFolder.close(false)
    }
}

class MailFolder(val folder: IMAPFolder) {

    fun readAll(): List<Mail> {
        return folder.messages.map {
            Mail(it)
        }
    }
}

class Mail(message: Message) {

    val mailInfo = MailInfo(message.subject, message.receivedDate, message.from.first() as InternetAddress)
}

data class MailInfo(
        val subject: String,
        val date: Date,
        val from: InternetAddress
)

fun Store.connect(connectionInformation: ConnectionInformation) = this.connect(
        connectionInformation.host,
        connectionInformation.port,
        connectionInformation.user,
        connectionInformation.password
)
