package de.fma.simplycom.board.view

import de.fma.simplycom.board.controller.BoardController
import de.fma.simplycom.board.model.Board
import de.fma.simplycom.board.view.styles.BoardViewStyles
import de.fma.simplycom.common.components.Icons
import de.fma.simplycom.common.components.iconButton
import javafx.application.Platform
import javafx.scene.control.TextArea
import tornadofx.ItemViewModel
import tornadofx.View
import tornadofx.action
import tornadofx.addClass
import tornadofx.borderpane
import tornadofx.bottom
import tornadofx.center
import tornadofx.left
import tornadofx.right
import tornadofx.singleAssign
import tornadofx.textarea
import tornadofx.top
import tornadofx.vbox

class BoardView : View("Board") {

    private val controller: BoardController by inject()
    private val model = BoardModel(controller.board)

    private var textArea: TextArea by singleAssign()

    override val root = borderpane {
        center {
            textArea = textarea(model.text) {
                addClass(BoardViewStyles.mainText)
                isWrapText = true
                textProperty().addListener { _, _, _ ->
                    Platform.runLater(this::end)
                }
            }
        }
        left {
            vbox {
                iconButton(Icons.EMAIL) {}
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

class BoardModel(board: Board) : ItemViewModel<Board>(board) {
    val text = bind(Board::textProperty)
}

