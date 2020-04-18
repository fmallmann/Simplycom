package de.fma.simplycom.board.viewmodel

import de.fma.simplycom.board.model.MailProperties
import tornadofx.ViewModel

class PreferencesViewModel : ViewModel() {
    var mailProperties = MailProperties()
    private val mailRepository: MailRepository by inject()

    init {
        val mailPropertiesEntity = mailRepository.load()
        if (mailPropertiesEntity != null) {
            mailProperties = MailProperties(
                    mailPropertiesEntity.shownName,
                    mailPropertiesEntity.imapHostname,
                    mailPropertiesEntity.smtpHostname,
                    mailPropertiesEntity.imapPort,
                    mailPropertiesEntity.smtpPort,
                    mailPropertiesEntity.username,
                    mailPropertiesEntity.password,
                    mailPropertiesEntity.enableSsl
            )
        }
    }


    fun save() {
        mailRepository.save(
                shownName = mailProperties.shownName.value,
                imapHostname = mailProperties.imapHostname.value,
                smtpHostname = mailProperties.smtpHostname.value,
                imapPort = mailProperties.imapPort.value,
                smtpPort = mailProperties.smtpPort.value,
                enableSsl = mailProperties.enableSsl.value,
                username = mailProperties.username.value,
                password = mailProperties.password.value
        )
    }
}
