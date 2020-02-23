package de.fma.simplycom.components

import de.fma.simplycom.controller.BoardController
import tornadofx.Fragment
import tornadofx.action
import tornadofx.gridpane
import tornadofx.gridpaneConstraints
import tornadofx.row

class NumbersKeyboard : Fragment() {

    private val controller: BoardController by inject()

    override val root = gridpane {
        row {
            letterButton("1", controller.board)
            letterButton("2", controller.board)
            letterButton("3", controller.board)
            letterButton("4", controller.board)
            letterButton("5", controller.board)
            letterButton("6", controller.board)
            letterButton("7", controller.board)
            letterButton("8", controller.board)
            letterButton("9", controller.board)
            letterButton("0", controller.board)
            letterButton("=", controller.board)
            letterButton("*", controller.board)
            letterButton("_", controller.board)
        }
        row {
            letterButton("-", controller.board)
            letterButton("/", controller.board)
            letterButton(":", controller.board)
            letterButton(";", controller.board)
            letterButton("(", controller.board)
            letterButton(")", controller.board)
            letterButton("$", controller.board)
            letterButton("&", controller.board)
            letterButton("@", controller.board)
            letterButton("€", controller.board)
            letterButton("<", controller.board)
            letterButton(">", controller.board)
            letterButton("§", controller.board)
        }
        row {
            letterButton(".", controller.board)
            letterButton(",", controller.board)
            letterButton("?", controller.board)
            letterButton("!", controller.board)
            letterButton("'", controller.board)
            letterButton("\"", controller.board)
            letterButton("#", controller.board)
            letterButton("%", controller.board)
            letterButton("^", controller.board)
            letterButton("+", controller.board)
            letterButton("`", controller.board)
            letterButton("´", controller.board)
            letterButton("ß", controller.board)
        }
        row {
            shiftButton {}
            lettersButton {
                action { replaceWith<LowercaseLettersKeyboard>() }
            }
            enterButton(controller.board)
            spaceButton(controller.board) {
                gridpaneConstraints {
                    columnSpan = 3
                }
            }
            backspaceButton(controller.board)
            letterButton(".", controller.board)
            letterButton(",", controller.board)
            letterButton("?", controller.board)
            letterButton("!", controller.board)
            letterButton(":", controller.board)
            letterButton("0", controller.board)
        }
    }
}
