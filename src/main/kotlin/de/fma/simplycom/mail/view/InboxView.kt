package de.fma.simplycom.mail.view

import de.fma.simplycom.board.view.BoardView
import de.fma.simplycom.common.components.Icons
import de.fma.simplycom.common.components.iconButton
import de.fma.simplycom.mail.components.mailPane
import de.fma.simplycom.mail.view.styles.MailStyles
import tornadofx.View
import tornadofx.action
import tornadofx.addClass
import tornadofx.asObservable
import tornadofx.borderpane
import tornadofx.center
import tornadofx.find
import tornadofx.left
import tornadofx.listview
import tornadofx.right
import tornadofx.top
import tornadofx.vbox

class InboxView : View("Mail") {

    override val root = mailPane(this) {
        borderpane {
            left {
                vbox {
                    iconButton(Icons.SEND_MAIL) {
                        action {
                            val sendMailScope = SendMailScope(this@InboxView)
                            val sendMailView = find<SendMailView>(sendMailScope)
                            replaceWith(sendMailView)
                        }
                    }
                    iconButton(Icons.ANSWER) {}
                    iconButton(Icons.ANSWER_ALL) {}
                    iconButton(Icons.FORWARD) {}
                    iconButton(Icons.ADD) {}
                }
            }
            right {
                borderpane {
                    top {
                        iconButton(Icons.CLOSE) {
                            action {
                                replaceWith<BoardView>()
                            }
                        }
                    }
                }
            }
            center {
                listview(emptyList<String>().asObservable()) {
                    addClass(MailStyles.mailList)
                }
            }
        }
    }
}

