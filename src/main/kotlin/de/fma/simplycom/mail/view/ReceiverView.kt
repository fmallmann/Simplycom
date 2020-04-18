package de.fma.simplycom.mail.view

import de.fma.simplycom.common.components.Icons
import de.fma.simplycom.common.components.iconButton
import de.fma.simplycom.common.components.keyboardPane
import de.fma.simplycom.mail.components.mailPane
import de.fma.simplycom.mail.view.styles.MailStyles
import de.fma.simplycom.mail.viewmodel.SendMailViewModel
import tornadofx.View
import tornadofx.action
import tornadofx.addClass
import tornadofx.borderpane
import tornadofx.center
import tornadofx.right
import tornadofx.textfield

class ReceiverView : View("Receiver") {

    val vm: SendMailViewModel by inject()

    override val root = keyboardPane {
        mailPane(this@ReceiverView) {
            borderpane {
                center {
                    textfield(vm.sendMail.receiver) {
                        addClass(MailStyles.mailText)
                    }
                }
                right {
                    iconButton(Icons.CHECKMARK) {
                        action {
                            replaceWith<SendMailView>()
                        }
                    }
                }
            }
        }
    }
}
