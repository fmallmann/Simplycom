package de.fma.simplycom.main.views

import de.fma.simplycom.board.model.Board
import de.fma.simplycom.board.view.BoardView
import de.fma.simplycom.main.components.UppercaseLettersKeyboard
import tornadofx.View
import tornadofx.borderpane
import tornadofx.bottom
import tornadofx.center

class MainView : View("Simplycom") {

    private val board = Board()

    override val root = borderpane {
        center {
            add(find<BoardView>(mapOf("board" to board)))
        }
        bottom {
            add(find<UppercaseLettersKeyboard>(mapOf("board" to board)))
        }
    }
}
