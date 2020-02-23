package de.fma.simplycom.components

import de.fma.simplycom.components.styles.BoardComponentStyles
import de.fma.simplycom.model.Board
import javafx.event.EventTarget
import javafx.scene.control.ButtonBase
import tornadofx.action
import tornadofx.addClass
import tornadofx.button
import tornadofx.fitToParentWidth
import tornadofx.gridpaneColumnConstraints
import tornadofx.label
import tornadofx.pane
import tornadofx.useMaxWidth

fun EventTarget.boardButton(letter: String, op: ButtonBase.() -> Unit = {}) {
    button(letter) {
        useMaxWidth = true
        isFocusTraversable = false
        addClass(BoardComponentStyles.letterButton)
        gridpaneColumnConstraints {
            percentWidth = 100.0
        }
        op.invoke(this)
    }
}

fun EventTarget.letterButton(letter: String, board: Board, op: ButtonBase.() -> Unit = {}) {
    boardButton(letter) {
        action {
            board.text += letter
        }
        op.invoke(this)
    }
}

fun EventTarget.enterButton(board: Board) {
    iconButton(Icons.ENTER) {
        action { board.text += "\n" }
    }
}

fun EventTarget.spaceButton(board: Board, function: ButtonBase.() -> Unit = {}) {
    letterButton(" ", board, function)
    label { }
    label { }
}

fun EventTarget.backspaceButton(board: Board) {
    iconButton(Icons.BACKSPACE) {
        action {
            board.text = if (board.text.isNotEmpty()) board.text.substring(0 until board.text.length - 1) else board.text
        }
    }
}

fun EventTarget.numbersButton(function: ButtonBase.() -> Unit = {}) {
    boardButton("123") {
        function.invoke(this)
    }
}

fun EventTarget.lettersButton(function: ButtonBase.() -> Unit = {}) {
    boardButton("ABC") {
        function.invoke(this)
    }
}

fun EventTarget.shiftButton(function: ButtonBase.() -> Unit = {}) {
    iconButton(Icons.SHIFT, function)
}

fun EventTarget.iconButton(icon: Icons, function: ButtonBase.() -> Unit = {}) {
    pane {
        gridpaneColumnConstraints {
            percentWidth = 100.0
        }
        button(graphic = icon(icon)) {
            fitToParentWidth()
            isFocusTraversable = false
            addClass(BoardComponentStyles.iconButton)
            function.invoke(this)
        }
    }
}
