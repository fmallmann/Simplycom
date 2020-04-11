package de.fma.simplycom.mail.viewmodel

import de.fma.simplycom.mail.model.Inbox
import tornadofx.ViewModel

class InboxViewModel : ViewModel() {

    val inbox: Inbox
    val mailService: MailService by inject()

    init {
        inbox = Inbox(loadMails())
    }

    fun loadMails(): MutableList<MailInfo> {
        return mailService.receiveMails()
    }
}
