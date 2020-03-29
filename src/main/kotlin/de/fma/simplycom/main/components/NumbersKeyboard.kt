package de.fma.simplycom.main.components

import de.fma.simplycom.board.model.Board
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

    private val board: Board by param()

    override val root = gridpane {
        row {
            letterButton("1", board)
            letterButton("2", board)
            letterButton("3", board)
            letterButton("4", board)
            letterButton("5", board)
            letterButton("6", board)
            letterButton("7", board)
            letterButton("8", board)
            letterButton("9", board)
            letterButton("0", board)
            letterButton("=", board)
            letterButton("*", board)
            letterButton("_", board)
        }
        row {
            letterButton("-", board)
            letterButton("/", board)
            letterButton(":", board)
            letterButton(";", board)
            letterButton("(", board)
            letterButton(")", board)
            letterButton("$", board)
            letterButton("&", board)
            letterButton("@", board)
            letterButton("€", board)
            letterButton("<", board)
            letterButton(">", board)
            letterButton("§", board)
        }
        row {
            letterButton(".", board)
            letterButton(",", board)
            letterButton("?", board)
            letterButton("!", board)
            letterButton("'", board)
            letterButton("\"", board)
            letterButton("#", board)
            letterButton("%", board)
            letterButton("^", board)
            letterButton("+", board)
            letterButton("`", board)
            letterButton("´", board)
            letterButton("ß", board)
        }
        row {
            shiftButton {}
            lettersButton {
                action {
                    val lowercaseLettersKeyboard = find<LowercaseLettersKeyboard>(mapOf("board" to board))
                    replaceWith(lowercaseLettersKeyboard)
                }
            }
            enterButton(board)
            spaceButton(board) {
                gridpaneConstraints {
                    columnSpan = 3
                }
            }
            backspaceButton(board)
            letterButton(".", board)
            letterButton(",", board)
            letterButton("?", board)
            letterButton("!", board)
            letterButton(":", board)
            letterButton("0", board)
        }
    }
}
