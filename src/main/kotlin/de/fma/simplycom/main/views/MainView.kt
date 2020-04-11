package de.fma.simplycom.main.views

import de.fma.simplycom.board.view.BoardView
import tornadofx.View
import tornadofx.borderpane
import tornadofx.center

class MainView : View("Simplycom") {

    override val root = borderpane {
        center {
            add(find<BoardView>())
        }
    }
}
