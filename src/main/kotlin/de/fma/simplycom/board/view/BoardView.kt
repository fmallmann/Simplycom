package de.fma.simplycom.board.view

import de.fma.simplycom.board.components.boardTextArea
import de.fma.simplycom.board.controller.BoardController
import de.fma.simplycom.board.model.Board
import de.fma.simplycom.board.model.BoardModel
import de.fma.simplycom.common.components.Icons
import de.fma.simplycom.common.components.iconButton
import de.fma.simplycom.common.components.scrollButtons
import javafx.scene.control.TextArea
import tornadofx.View
import tornadofx.action
import tornadofx.borderpane
import tornadofx.bottom
import tornadofx.center
import tornadofx.hbox
import tornadofx.left
import tornadofx.right
import tornadofx.singleAssign
import tornadofx.top
import tornadofx.vbox

class BoardView : View("Board") {

    private val controller: BoardController by inject()
    private val board: Board by param()
    private val model = BoardModel(board)

    private var textArea: TextArea by singleAssign()

    override val root = borderpane {
        center {
            textArea = boardTextArea(model)
        }
        left {
            vbox {
                hbox {
                    iconButton(Icons.TRASH) {
                        action { controller.deleteAll(board) }
                    }
                }
            }
        }
        right {
            borderpane {
                top {
                    iconButton(Icons.QUIT) {
                        action {
                            controller.close()
                        }
                    }
                }
                bottom {
                    scrollButtons(textArea)
                }
            }
        }
    }
}

