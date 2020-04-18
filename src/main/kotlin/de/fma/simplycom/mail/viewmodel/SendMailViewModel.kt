package de.fma.simplycom.mail.viewmodel

import de.fma.simplycom.mail.model.SendMail
import tornadofx.ViewModel

class SendMailViewModel : ViewModel() {

    val mailService: MailService by inject()

    val sendMail = SendMail()

    fun sendMail() {
        mailService.sendMail(sendMail.receiver.value, sendMail.subject.value, sendMail.text.value)
    }
}
