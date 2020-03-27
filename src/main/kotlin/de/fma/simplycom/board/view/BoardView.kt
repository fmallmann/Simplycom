package de.fma.simplycom.board.view

import de.fma.simplycom.board.controller.BoardController
import de.fma.simplycom.common.components.Icons
import de.fma.simplycom.common.components.iconButton
import de.fma.simplycom.board.model.Board
import de.fma.simplycom.board.view.styles.BoardViewStyles
import javafx.application.Platform
import tornadofx.ItemViewModel
import tornadofx.View
import tornadofx.addClass
import tornadofx.borderpane
import tornadofx.center
import tornadofx.left
import tornadofx.textarea
import tornadofx.vbox

class BoardView : View("Board") {

    private val controller: BoardController by inject()
    private val model = BoardModel(controller.board)

    override val root = borderpane {
        center {
            textarea(model.text) {
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
    }
}

class BoardModel(board: Board) : ItemViewModel<Board>(board) {
    val text = bind(Board::textProperty)
}

