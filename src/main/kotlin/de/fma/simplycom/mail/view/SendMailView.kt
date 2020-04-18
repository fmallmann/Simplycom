package de.fma.simplycom.mail.view

import de.fma.simplycom.board.components.boardTextArea
import de.fma.simplycom.common.components.Icons
import de.fma.simplycom.common.components.iconButton
import de.fma.simplycom.common.components.keyboardPane
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
import tornadofx.label
import tornadofx.left
import tornadofx.right
import tornadofx.singleAssign
import tornadofx.stringBinding
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

    override val root = keyboardPane {
        mailPane(this@SendMailView) {
            borderpane {
                center {
                    vbox {
                        label(vm.sendMail.receiver.stringBinding { it ?: "Kein Empfänger ausgewählt!" }) {
                            addClass(MailStyles.receiver)
                        }
                        textfield(vm.sendMail.subject) {
                            addClass(MailStyles.mailText)
                        }
                        textArea = boardTextArea(vm.sendMail.text)
                    }
                }
                left {
                    vbox {
                        iconButton(Icons.CONTACTS) {
                            action {
                                replaceWith<ReceiverView>()
                            }
                        }
                        iconButton(Icons.CHOOSE_FILE) {}
                        iconButton(Icons.SEND_MAIL) {
                            action {
                                try {
                                    vm.sendMail()
                                    replaceWith(scope.calledFrom)
                                } catch (e: Exception) {
                                    e.printStackTrace()
                                }
                            }
                        }
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
}

class SendMailScope(val calledFrom: View, val text: String = "") : Scope() {
}
