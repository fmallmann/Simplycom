package de.fma.simplycom.common.components

import de.fma.simplycom.common.components.styles.BoardComponentStyles
import javafx.event.EventTarget
import javafx.event.EventType
import javafx.scene.control.ButtonBase
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
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
        addClass(BoardComponentStyles.boardButton)
        gridpaneColumnConstraints {
            percentWidth = 100.0
        }
        op.invoke(this)
    }
}

fun EventTarget.letterButton(letter: String, op: ButtonBase.() -> Unit = {}) {
    boardButton(letter) {
        action {
            pressKey(letter)
        }
        op.invoke(this)
    }
}

fun EventTarget.enterButton() {
    iconButton(Icons.ENTER) {
        action {
            pressKey(code = KeyCode.ENTER)
        }
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
            pressKey(code = KeyCode.BACK_SPACE)
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

fun ButtonBase.pressKey(letter: String = KeyEvent.CHAR_UNDEFINED, code: KeyCode = KeyCode.UNDEFINED) {
    scene.focusOwner.fireEvent(createKeyEvent(this, scene.focusOwner, KeyEvent.KEY_PRESSED, letter, code))
    scene.focusOwner.fireEvent(createKeyEvent(this, scene.focusOwner, KeyEvent.KEY_RELEASED, letter, code))
    scene.focusOwner.fireEvent(createKeyEvent(this, scene.focusOwner, KeyEvent.KEY_TYPED, letter, code))
}

fun createKeyEvent(source: Any, target: EventTarget, eventType: EventType<KeyEvent>, character: String, code: KeyCode): KeyEvent {
    return KeyEvent(source, target, eventType, character, code.toString(),
            code, false, false,
            false, false)
}
