package de.fma.simplycom.main.components

import de.fma.simplycom.board.model.Board
import de.fma.simplycom.common.components.backspaceButton
import de.fma.simplycom.common.components.enterButton
import de.fma.simplycom.common.components.letterButton
import de.fma.simplycom.common.components.numbersButton
import de.fma.simplycom.common.components.shiftButton
import de.fma.simplycom.common.components.spaceButton
import tornadofx.View
import tornadofx.action
import tornadofx.gridpane
import tornadofx.gridpaneConstraints
import tornadofx.row

class LowercaseLettersKeyboard : View() {

    private val board: Board by param()

    override val root = gridpane {
        row {
            letterButton("q", board)
            letterButton("w", board)
            letterButton("e", board)
            letterButton("r", board)
            letterButton("t", board)
            letterButton("z", board)
            letterButton("u", board)
            letterButton("i", board)
            letterButton("o", board)
            letterButton("p", board)
            letterButton("7", board)
            letterButton("8", board)
            letterButton("9", board)
        }
        row {
            letterButton("a", board)
            letterButton("s", board)
            letterButton("d", board)
            letterButton("f", board)
            letterButton("g", board)
            letterButton("h", board)
            letterButton("j", board)
            letterButton("k", board)
            letterButton("l", board)
            letterButton("ü", board)
            letterButton("4", board)
            letterButton("5", board)
            letterButton("6", board)
        }
        row {
            letterButton("ä", board)
            letterButton("ss", board)
            letterButton("y", board)
            letterButton("x", board)
            letterButton("c", board)
            letterButton("v", board)
            letterButton("b", board)
            letterButton("n", board)
            letterButton("m", board)
            letterButton("ö", board)
            letterButton("1", board)
            letterButton("2", board)
            letterButton("3", board)
        }
        row {
            shiftButton() {
                action {
                    val uppercaseLettersKeyboard = find<UppercaseLettersKeyboard>(mapOf("board" to board))
                    replaceWith(uppercaseLettersKeyboard)
                }
            }
            numbersButton() {
                action {
                    val numbersKeyboard = find<NumbersKeyboard>(mapOf("board" to board))
                    replaceWith(numbersKeyboard)
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
