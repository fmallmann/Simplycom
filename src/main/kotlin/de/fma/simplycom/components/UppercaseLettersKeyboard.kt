package de.fma.simplycom.components

import de.fma.simplycom.controller.BoardController
import tornadofx.Fragment
import tornadofx.action
import tornadofx.c
import tornadofx.gridpane
import tornadofx.gridpaneConstraints
import tornadofx.row
import tornadofx.style

class UppercaseLettersKeyboard : Fragment() {

    private val controller: BoardController by inject()

    override val root = gridpane {
        row {
            letterButton("Q", controller.board)
            letterButton("W", controller.board)
            letterButton("E", controller.board)
            letterButton("R", controller.board)
            letterButton("T", controller.board)
            letterButton("Z", controller.board)
            letterButton("U", controller.board)
            letterButton("I", controller.board)
            letterButton("O", controller.board)
            letterButton("P", controller.board)
            letterButton("7", controller.board)
            letterButton("8", controller.board)
            letterButton("9", controller.board)
        }
        row {
            letterButton("A", controller.board)
            letterButton("S", controller.board)
            letterButton("D", controller.board)
            letterButton("F", controller.board)
            letterButton("G", controller.board)
            letterButton("H", controller.board)
            letterButton("J", controller.board)
            letterButton("K", controller.board)
            letterButton("L", controller.board)
            letterButton("Ü", controller.board)
            letterButton("4", controller.board)
            letterButton("5", controller.board)
            letterButton("6", controller.board)
        }
        row {
            letterButton("Ä", controller.board)
            letterButton("SS", controller.board)
            letterButton("Y", controller.board)
            letterButton("X", controller.board)
            letterButton("C", controller.board)
            letterButton("V", controller.board)
            letterButton("B", controller.board)
            letterButton("N", controller.board)
            letterButton("M", controller.board)
            letterButton("Ö", controller.board)
            letterButton("1", controller.board)
            letterButton("2", controller.board)
            letterButton("3", controller.board)
        }
        row {
            shiftButton {
                action { replaceWith<LowercaseLettersKeyboard>() }
                style {
                    backgroundColor += c("lightblue")
                }
            }
            numbersButton {
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
