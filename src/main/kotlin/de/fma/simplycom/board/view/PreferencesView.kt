package de.fma.simplycom.board.view

import de.fma.simplycom.board.model.MailProperties
import de.fma.simplycom.board.view.styles.BoardViewStyles
import de.fma.simplycom.board.viewmodel.PreferencesViewModel
import de.fma.simplycom.common.components.Icons
import de.fma.simplycom.common.components.iconButton
import de.fma.simplycom.common.components.keyboardPane
import de.fma.simplycom.common.components.scrollButtons
import javafx.event.EventTarget
import javafx.scene.control.ScrollPane
import tornadofx.View
import tornadofx.action
import tornadofx.addClass
import tornadofx.borderpane
import tornadofx.bottom
import tornadofx.center
import tornadofx.checkbox
import tornadofx.field
import tornadofx.fieldset
import tornadofx.fitToParentSize
import tornadofx.form
import tornadofx.hbox
import tornadofx.label
import tornadofx.left
import tornadofx.passwordfield
import tornadofx.right
import tornadofx.scrollpane
import tornadofx.singleAssign
import tornadofx.textfield
import tornadofx.top
import tornadofx.vbox

class PreferencesView : View("Einstellungen") {

    val vm: PreferencesViewModel by inject()

    var content: ScrollPane by singleAssign()

    override val root = keyboardPane {
        borderpane {
            left {
                vbox {
                    iconButton(Icons.EMAIL) {}
                }
            }
            center {
                content = scrollpane {
                    emailPreferences(vm.mailProperties)
                }
            }
            right {
                borderpane {
                    top {
                        hbox {
                            iconButton(Icons.CHECKMARK) {
                                action { vm.save() }
                            }
                            iconButton(Icons.CLOSE) {
                                action { replaceWith<BoardView>() }
                            }
                        }
                    }
                    bottom {
                        hbox {
                            label { }
                            scrollButtons(content)
                        }
                    }
                }
            }
        }
    }
}

fun EventTarget.emailPreferences(mailProperties: MailProperties) {
    form {
        fitToParentSize()
        fieldset("Email") {
            addClass(BoardViewStyles.preferencesText)
            field("Hostname") {
                textfield(mailProperties.hostname)
            }
            field("SSL verwenden") {
                checkbox(property = mailProperties.enableSsl)
            }
            field("Port") {
                textfield(mailProperties.port)
            }
            field("Benutzername") {
                textfield(mailProperties.username)
            }
            field("Passwort") {
                passwordfield(mailProperties.password)
            }
        }
    }
}
