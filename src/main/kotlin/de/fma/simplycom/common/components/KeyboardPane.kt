package de.fma.simplycom.common.components

import de.fma.simplycom.main.components.uppercaseLetters
import javafx.event.EventTarget
import javafx.scene.Parent
import javafx.scene.layout.BorderPane
import javafx.scene.layout.Pane
import tornadofx.bottom
import tornadofx.center
import tornadofx.opcr

fun EventTarget.keyboardPane(op: Pane.() -> Unit = {}): Parent {
    return opcr(this, BorderPane()) {
        center {
            op(this)
        }
        bottom {
            uppercaseLetters()
        }
    }
}
