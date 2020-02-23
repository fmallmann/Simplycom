package de.fma.simplycom.views.styles

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
