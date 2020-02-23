package de.fma.simplycom.views

import de.fma.simplycom.components.Icons
import de.fma.simplycom.components.UppercaseLettersKeyboard
import de.fma.simplycom.components.iconButton
import de.fma.simplycom.controller.BoardController
import de.fma.simplycom.model.Board
import de.fma.simplycom.views.styles.BoardViewStyles
import javafx.application.Platform
import tornadofx.*

class BoardView : View("Simplycom") {

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
        bottom {
            add(find<UppercaseLettersKeyboard>())
        }
    }
}

class BoardModel(board: Board) : ItemViewModel<Board>(board) {
    val text = bind(Board::textProperty)
}
