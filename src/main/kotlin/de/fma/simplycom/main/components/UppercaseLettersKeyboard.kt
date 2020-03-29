package de.fma.simplycom.main.components

import de.fma.simplycom.common.components.backspaceButton
import de.fma.simplycom.common.components.enterButton
import de.fma.simplycom.common.components.letterButton
import de.fma.simplycom.common.components.numbersButton
import de.fma.simplycom.common.components.shiftButton
import de.fma.simplycom.common.components.spaceButton
import tornadofx.View
import tornadofx.action
import tornadofx.c
import tornadofx.gridpane
import tornadofx.gridpaneConstraints
import tornadofx.row
import tornadofx.style

class UppercaseLettersKeyboard : View() {

    override val root = gridpane {
        row {
            letterButton("Q")
            letterButton("W")
            letterButton("E")
            letterButton("R")
            letterButton("T")
            letterButton("Z")
            letterButton("U")
            letterButton("I")
            letterButton("O")
            letterButton("P")
            letterButton("7")
            letterButton("8")
            letterButton("9")
        }
        row {
            letterButton("A")
            letterButton("S")
            letterButton("D")
            letterButton("F")
            letterButton("G")
            letterButton("H")
            letterButton("J")
            letterButton("K")
            letterButton("L")
            letterButton("Ü")
            letterButton("4")
            letterButton("5")
            letterButton("6")
        }
        row {
            letterButton("Ä")
            letterButton("SS")
            letterButton("Y")
            letterButton("X")
            letterButton("C")
            letterButton("V")
            letterButton("B")
            letterButton("N")
            letterButton("M")
            letterButton("Ö")
            letterButton("1")
            letterButton("2")
            letterButton("3")
        }
        row {
            shiftButton {
                action {
                    val lowercaseLettersKeyboard = find<LowercaseLettersKeyboard>()
                    replaceWith(lowercaseLettersKeyboard)
                }
                style {
                    backgroundColor += c("lightblue")
                }
            }
            numbersButton {
                action {
                    val numbersKeyboard = find<NumbersKeyboard>()
                    replaceWith(numbersKeyboard)
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
}
