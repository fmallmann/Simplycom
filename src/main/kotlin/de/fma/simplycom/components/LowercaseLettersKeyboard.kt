package de.fma.simplycom.components

import de.fma.simplycom.controller.BoardController
import tornadofx.Fragment
import tornadofx.action
import tornadofx.gridpane
import tornadofx.gridpaneConstraints
import tornadofx.row

class LowercaseLettersKeyboard : Fragment() {

    private val controller: BoardController by inject()

    override val root = gridpane {
        row {
            letterButton("q", controller.board)
            letterButton("w", controller.board)
            letterButton("e", controller.board)
            letterButton("r", controller.board)
            letterButton("t", controller.board)
            letterButton("z", controller.board)
            letterButton("u", controller.board)
            letterButton("i", controller.board)
            letterButton("o", controller.board)
            letterButton("p", controller.board)
            letterButton("7", controller.board)
            letterButton("8", controller.board)
            letterButton("9", controller.board)
        }
        row {
            letterButton("a", controller.board)
            letterButton("s", controller.board)
            letterButton("d", controller.board)
            letterButton("f", controller.board)
            letterButton("g", controller.board)
            letterButton("h", controller.board)
            letterButton("j", controller.board)
            letterButton("k", controller.board)
            letterButton("l", controller.board)
            letterButton("ü", controller.board)
            letterButton("4", controller.board)
            letterButton("5", controller.board)
            letterButton("6", controller.board)
        }
        row {
            letterButton("ä", controller.board)
            letterButton("ss", controller.board)
            letterButton("y", controller.board)
            letterButton("x", controller.board)
            letterButton("c", controller.board)
            letterButton("v", controller.board)
            letterButton("b", controller.board)
            letterButton("n", controller.board)
            letterButton("m", controller.board)
            letterButton("ö", controller.board)
            letterButton("1", controller.board)
            letterButton("2", controller.board)
            letterButton("3", controller.board)
        }
        row {
            shiftButton() {
                action {replaceWith<UppercaseLettersKeyboard>()}
            }
            numbersButton() {
                action { replaceWith<NumbersKeyboard>() }
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
