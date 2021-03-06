package de.fma.simplycom.common.components

import javafx.scene.control.TextArea
import javafx.scene.layout.Pane
import tornadofx.action
import tornadofx.vbox

fun Pane.scrollButtons(textArea: TextArea) {
    vbox {
        iconButton(Icons.ALL_SCROLL_UP) {
            action { textArea.scrollTop = Double.MIN_VALUE }
        }
        iconButton(Icons.SCROLL_UP) {
            action { textArea.scrollTop -= 60.0 }
        }
        iconButton(Icons.SCROLL_DOWN) {
            action { textArea.scrollTop += 60.0 }
        }
        iconButton(Icons.ALL_SCROLL_DOWM) {
            action { textArea.scrollTop = Double.MAX_VALUE }
        }
    }
}
