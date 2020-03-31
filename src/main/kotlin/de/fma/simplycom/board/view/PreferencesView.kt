package de.fma.simplycom.board.view

import de.fma.simplycom.common.components.Icons
import de.fma.simplycom.common.components.iconButton
import tornadofx.View
import tornadofx.action
import tornadofx.borderpane
import tornadofx.center
import tornadofx.label
import tornadofx.right

class PreferencesView : View("Einstellungen") {

    override val root = borderpane {
        center {
            label("${primaryStage.width}x${primaryStage.height}")
        }
        right {
            iconButton(Icons.CLOSE) {
                action { replaceWith<BoardView>() }
            }
        }
    }
}
