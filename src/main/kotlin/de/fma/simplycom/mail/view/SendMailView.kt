package de.fma.simplycom.mail.view

import de.fma.simplycom.board.components.boardTextArea
import de.fma.simplycom.common.components.Icons
import de.fma.simplycom.common.components.iconButton
import de.fma.simplycom.common.components.scrollButtons
import de.fma.simplycom.mail.components.mailPane
import de.fma.simplycom.mail.view.styles.MailStyles
import de.fma.simplycom.mail.viewmodel.SendMailViewModel
import javafx.scene.control.TextArea
import tornadofx.Scope
import tornadofx.View
import tornadofx.action
import tornadofx.addClass
import tornadofx.borderpane
import tornadofx.bottom
import tornadofx.center
import tornadofx.left
import tornadofx.right
import tornadofx.singleAssign
import tornadofx.textfield
import tornadofx.top
import tornadofx.vbox

class SendMailView : View("Send Mail") {

    override val scope = super.scope as SendMailScope
    private val vm: SendMailViewModel by inject()

    private var textArea: TextArea by singleAssign()

    init {
        vm.sendMail.text.value = scope.text
    }

    override val root = mailPane(this) {
        borderpane {
            center {
                vbox {
                    textfield(vm.sendMail.subject) {
                        addClass(MailStyles.subject)
                    }
                    textArea = boardTextArea(vm.sendMail.text)
                }
            }
            left {
                vbox {
                    iconButton(Icons.CONTACTS) {}
                    iconButton(Icons.CHOOSE_FILE) {}
                    iconButton(Icons.SEND_MAIL) {}
                }
            }
            right {
                borderpane {
                    top {
                        iconButton(Icons.CLOSE) {
                            action {
                                replaceWith(scope.calledFrom)
                            }
                        }
                    }
                    bottom {
                        scrollButtons(textArea)
                    }
                }
            }
        }
    }
}

class SendMailScope(val calledFrom: View, val text: String = "") : Scope() {
}
