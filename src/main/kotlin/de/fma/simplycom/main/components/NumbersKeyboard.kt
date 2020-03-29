package de.fma.simplycom.main.components

import de.fma.simplycom.common.components.backspaceButton
import de.fma.simplycom.common.components.enterButton
import de.fma.simplycom.common.components.letterButton
import de.fma.simplycom.common.components.lettersButton
import de.fma.simplycom.common.components.shiftButton
import de.fma.simplycom.common.components.spaceButton
import tornadofx.View
import tornadofx.action
import tornadofx.gridpane
import tornadofx.gridpaneConstraints
import tornadofx.row

class NumbersKeyboard : View() {

    override val root = gridpane {
        row {
            letterButton("1")
            letterButton("2")
            letterButton("3")
            letterButton("4")
            letterButton("5")
            letterButton("6")
            letterButton("7")
            letterButton("8")
            letterButton("9")
            letterButton("0")
            letterButton("=")
            letterButton("*")
            letterButton("_")
        }
        row {
            letterButton("-")
            letterButton("/")
            letterButton(":")
            letterButton(";")
            letterButton("(")
            letterButton(")")
            letterButton("$")
            letterButton("&")
            letterButton("@")
            letterButton("€")
            letterButton("<")
            letterButton(">")
            letterButton("§")
        }
        row {
            letterButton(".")
            letterButton(",")
            letterButton("?")
            letterButton("!")
            letterButton("'")
            letterButton("\"")
            letterButton("#")
            letterButton("%")
            letterButton("^")
            letterButton("+")
            letterButton("`")
            letterButton("´")
            letterButton("ß")
        }
        row {
            shiftButton {}
            lettersButton {
                action {
                    val lowercaseLettersKeyboard = find<LowercaseLettersKeyboard>()
                    replaceWith(lowercaseLettersKeyboard)
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
