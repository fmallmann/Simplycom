package de.fma.simplycom.board.view

import de.fma.simplycom.board.components.boardTextArea
import de.fma.simplycom.board.controller.BoardController
import de.fma.simplycom.board.model.BoardModel
import de.fma.simplycom.common.components.Icons
import de.fma.simplycom.common.components.iconButton
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
    private val model = BoardModel(controller.board)

    private var textArea: TextArea by singleAssign()

    override val root = borderpane {
        center {
            textArea = boardTextArea(model)
        }
        left {
            vbox {
                hbox {
                    iconButton(Icons.TRASH) {
                        action { controller.deleteAll() }
                    }
                    iconButton(Icons.EMAIL) {}
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
                    vbox {
                        iconButton(Icons.ALL_SCROLL_UP) {
                            action { textArea.scrollTop = Double.MIN_VALUE }
                        }
                        iconButton(Icons.SCROLL_UP) {
                            action { textArea.scrollTop -= 60.0 }
                        }
                        iconButton(Icons.SCROLL_DOWN) {
                            action { textArea.scrollTop += 60.0 }
                        }
                        iconButton(Icons.ALL_SCROLL_DOWM) {
                            action { textArea.scrollTop = Double.MAX_VALUE }
                        }
                    }
                }
            }
        }
    }
}

