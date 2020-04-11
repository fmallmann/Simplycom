package de.fma.simplycom.mail.components

import de.fma.simplycom.common.components.Icons
import de.fma.simplycom.common.components.iconButton
import de.fma.simplycom.mail.view.InboxView
import javafx.event.EventTarget
import javafx.scene.Parent
import javafx.scene.layout.BorderPane
import javafx.scene.layout.Pane
import tornadofx.View
import tornadofx.action
import tornadofx.center
import tornadofx.left
import tornadofx.opcr
import tornadofx.vbox

fun EventTarget.mailPane(view: View, op: Pane.() -> Unit): Parent {
    return opcr(this, BorderPane()) {
        left {
            vbox {
                iconButton(Icons.INBOX) {
                    action { view.replaceWith<InboxView>() }
                }
                iconButton(Icons.OUTBOX) {
                    action { }
                }
                iconButton(Icons.ADRESSES) {
                    action { }
                }
            }
        }
        center {
            op.invoke(this)
        }
    }
}
