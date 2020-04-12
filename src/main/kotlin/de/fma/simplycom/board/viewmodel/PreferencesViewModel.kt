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
                    mailPropertiesEntity.imapHostname,
                    mailPropertiesEntity.smtpHostname,
                    mailPropertiesEntity.port,
                    mailPropertiesEntity.username,
                    mailPropertiesEntity.password,
                    mailPropertiesEntity.enableSsl
            )
        }
    }


    fun save() {
        mailRepository.save(
                imapHostname = mailProperties.imapHostname.value,
                smtpHostname = mailProperties.smtpHostname.value,
                port = mailProperties.port.value,
                enableSsl = mailProperties.enableSsl.value,
                username = mailProperties.username.value,
                password = mailProperties.password.value
        )
    }
}
