package de.fma.simplycom.board.view.styles

import javafx.scene.control.ScrollPane
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.pt
import tornadofx.px

class BoardViewStyles : Stylesheet() {
    companion object {
        val mainText by cssclass()
    }

    init {
        mainText {
            content {
                padding = box(5.px, 10.px)
            }
            fontSize = 30.pt
            scrollPane {
                hBarPolicy = ScrollPane.ScrollBarPolicy.NEVER
            }
        }
    }
}
