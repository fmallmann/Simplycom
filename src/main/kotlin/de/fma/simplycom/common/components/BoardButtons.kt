package de.fma.simplycom.common.components

import de.fma.simplycom.common.components.styles.BoardComponentStyles
import javafx.event.EventTarget
import javafx.scene.control.ButtonBase
import tornadofx.FXEvent
import tornadofx.View
import tornadofx.action
import tornadofx.addClass
import tornadofx.button
import tornadofx.findParent
import tornadofx.fitToParentWidth
import tornadofx.gridpaneColumnConstraints
import tornadofx.label
import tornadofx.pane
import tornadofx.useMaxWidth

class LetterButtonCliecked(val letter: String) : FXEvent()
class BackspaceButtonClicked() : FXEvent()

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

fun EventTarget.letterButton(letter: String, op: ButtonBase.() -> Unit = {}) {
    boardButton(letter) {
        action {
            findParent<View>()?.fire(LetterButtonCliecked(letter))
        }
        op.invoke(this)
    }
}

fun EventTarget.enterButton() {
    iconButton(Icons.ENTER) {
        action { findParent<View>()?.fire(LetterButtonCliecked("\n")) }
    }
}

fun EventTarget.spaceButton(function: ButtonBase.() -> Unit = {}) {
    letterButton(" ", function)
    label { }
    label { }
}

fun EventTarget.backspaceButton() {
    iconButton(Icons.BACKSPACE) {
        action {
            findParent<View>()?.fire(BackspaceButtonClicked())
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
