package de.fma.simplycom.main.views

import de.fma.simplycom.board.view.BoardView
import de.fma.simplycom.main.components.UppercaseLettersKeyboard
import tornadofx.*

class MainView : View("Simplycom") {

    override val root = borderpane {
        center {
            add(find<BoardView>())
        }
        bottom {
            add(find<UppercaseLettersKeyboard>())
        }
    }
}
