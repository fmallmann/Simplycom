package de.fma.simplycom.main.components

import de.fma.simplycom.common.components.backspaceButton
import de.fma.simplycom.common.components.enterButton
import de.fma.simplycom.common.components.letterButton
import de.fma.simplycom.common.components.numbersButton
import de.fma.simplycom.common.components.shiftButton
import de.fma.simplycom.common.components.spaceButton
import javafx.event.EventTarget
import javafx.scene.layout.GridPane
import tornadofx.action
import tornadofx.gridpane
import tornadofx.gridpaneConstraints
import tornadofx.replaceWith
import tornadofx.row

fun EventTarget.lowercaseLetters(): GridPane = gridpane {
    row {
        letterButton("q")
        letterButton("w")
        letterButton("e")
        letterButton("r")
        letterButton("t")
        letterButton("z")
        letterButton("u")
        letterButton("i")
        letterButton("o")
        letterButton("p")
        letterButton("7")
        letterButton("8")
        letterButton("9")
    }
    row {
        letterButton("a")
        letterButton("s")
        letterButton("d")
        letterButton("f")
        letterButton("g")
        letterButton("h")
        letterButton("j")
        letterButton("k")
        letterButton("l")
        letterButton("ü")
        letterButton("4")
        letterButton("5")
        letterButton("6")
    }
    row {
        letterButton("ä")
        letterButton("ss")
        letterButton("y")
        letterButton("x")
        letterButton("c")
        letterButton("v")
        letterButton("b")
        letterButton("n")
        letterButton("m")
        letterButton("ö")
        letterButton("1")
        letterButton("2")
        letterButton("3")
    }
    row {
        shiftButton() {
            action {
                this@gridpane.replaceWith(uppercaseLetters())
            }
        }
        numbersButton() {
            action {
                this@gridpane.replaceWith(numbers())
            }
        }
        enterButton()
        spaceButton() {
            gridpaneConstraints {
                columnSpan = 3
            }
        }
        backspaceButton()
        letterButton(".")
        letterButton(",")
        letterButton("?")
        letterButton("!")
        letterButton(":")
        letterButton("0")
    }
}
