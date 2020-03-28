package de.fma.simplycom.board.components

import de.fma.simplycom.board.model.BoardModel
import de.fma.simplycom.board.view.styles.BoardViewStyles
import javafx.application.Platform
import javafx.event.EventTarget
import javafx.scene.control.TextArea
import tornadofx.addClass
import tornadofx.textarea

fun EventTarget.boardTextArea(model: BoardModel): TextArea {
    return textarea(model.text) {
        addClass(BoardViewStyles.mainText)
        isWrapText = true
        textProperty().addListener { _, _, _ ->
            Platform.runLater(this::end)
        }
    }
}
