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
import tornadofx.c
import tornadofx.gridpane
import tornadofx.gridpaneConstraints
import tornadofx.row
import tornadofx.style

class UppercaseLettersKeyboard : View() {

    private val board: Board by param()

    override val root = gridpane {
        row {
            letterButton("Q", board)
            letterButton("W", board)
            letterButton("E", board)
            letterButton("R", board)
            letterButton("T", board)
            letterButton("Z", board)
            letterButton("U", board)
            letterButton("I", board)
            letterButton("O", board)
            letterButton("P", board)
            letterButton("7", board)
            letterButton("8", board)
            letterButton("9", board)
        }
        row {
            letterButton("A", board)
            letterButton("S", board)
            letterButton("D", board)
            letterButton("F", board)
            letterButton("G", board)
            letterButton("H", board)
            letterButton("J", board)
            letterButton("K", board)
            letterButton("L", board)
            letterButton("Ü", board)
            letterButton("4", board)
            letterButton("5", board)
            letterButton("6", board)
        }
        row {
            letterButton("Ä", board)
            letterButton("SS", board)
            letterButton("Y", board)
            letterButton("X", board)
            letterButton("C", board)
            letterButton("V", board)
            letterButton("B", board)
            letterButton("N", board)
            letterButton("M", board)
            letterButton("Ö", board)
            letterButton("1", board)
            letterButton("2", board)
            letterButton("3", board)
        }
        row {
            shiftButton {
                action {
                    val lowercaseLettersKeyboard = find<LowercaseLettersKeyboard>(mapOf("board" to board))
                    replaceWith(lowercaseLettersKeyboard)
                }
                style {
                    backgroundColor += c("lightblue")
                }
            }
            numbersButton {
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
