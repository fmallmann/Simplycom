package de.fma.simplycom.board.components

import de.fma.simplycom.board.view.styles.BoardViewStyles
import javafx.beans.property.StringProperty
import javafx.event.EventTarget
import javafx.scene.control.TextArea
import tornadofx.addClass
import tornadofx.textarea

fun EventTarget.boardTextArea(text: StringProperty): TextArea {
    return textarea(text) {
        addClass(BoardViewStyles.mainText)
        isWrapText = true
    }
}
