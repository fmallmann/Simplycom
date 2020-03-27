package de.fma.simplycom.board.view.styles

import javafx.scene.control.ScrollPane
import tornadofx.*

class BoardViewStyles : Stylesheet() {
    companion object {
        val mainText by cssclass()
    }

    init {
        mainText {
            fontSize = 30.pt
            scrollPane {
                hBarPolicy = ScrollPane.ScrollBarPolicy.NEVER
            }
        }
    }
}
