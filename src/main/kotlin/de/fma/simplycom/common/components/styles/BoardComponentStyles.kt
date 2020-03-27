package de.fma.simplycom.common.components.styles

import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.pt
import tornadofx.px

class BoardComponentStyles: Stylesheet() {
    companion object {
        val iconButton by cssclass()
        val letterButton by cssclass()
    }

    init {
        letterButton {
            fontSize = 30.pt
            padding = box(10.px, 0.px)
        }

        iconButton {
            padding = box(0.px)
        }
    }
}

