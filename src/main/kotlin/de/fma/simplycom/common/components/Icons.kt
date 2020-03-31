package de.fma.simplycom.common.components

import javafx.event.EventTarget
import javafx.scene.image.ImageView
import tornadofx.imageview

enum class Icons {
    ENTER,
    SHIFT,
    BACKSPACE,
    EMAIL,
    QUIT,
    ALL_SCROLL_UP,
    ALL_SCROLL_DOWM,
    SCROLL_UP,
    SCROLL_DOWN,
    TRASH,
    PREFERENCES,
    CLOSE
}

fun EventTarget.icon(icon: Icons): ImageView {
    return when (icon) {
        Icons.ENTER -> enterIcon()
        Icons.SHIFT -> shiftIcon()
        Icons.BACKSPACE -> backspaceIcon()
        Icons.EMAIL -> emailIcon()
        Icons.QUIT -> quitIcon()
        Icons.ALL_SCROLL_UP -> allScrollUpIcon()
        Icons.ALL_SCROLL_DOWM -> allScrollDownIcon()
        Icons.SCROLL_UP -> scrollUpIcon()
        Icons.SCROLL_DOWN -> scrollDownIcon()
        Icons.TRASH -> trashIcon()
        Icons.PREFERENCES -> preferencesIcon()
        Icons.CLOSE -> closeIcon()
    }
}

fun EventTarget.closeIcon(): ImageView = iconImageView("/assets/close.png")

fun EventTarget.preferencesIcon(): ImageView = iconImageView("/assets/preferences.png")

fun EventTarget.trashIcon(): ImageView {
    return iconImageView("/assets/trash.png")
}

fun EventTarget.scrollUpIcon(): ImageView {
    return iconImageView("/assets/scroll.png", 180.0)
}

fun EventTarget.allScrollUpIcon(): ImageView {
    return iconImageView("/assets/all_scroll.png", 180.0)
}

fun EventTarget.scrollDownIcon(): ImageView {
    return iconImageView("/assets/scroll.png")
}

fun EventTarget.allScrollDownIcon(): ImageView {
    return iconImageView("/assets/all_scroll.png")
}

fun EventTarget.quitIcon(): ImageView {
    return iconImageView("/assets/quit.png")
}

fun EventTarget.enterIcon(): ImageView {
    return iconImageView("/assets/enter.png")
}

fun EventTarget.emailIcon(): ImageView {
    return iconImageView("/assets/email.png")
}

fun EventTarget.shiftIcon(): ImageView {
    return iconImageView("/assets/arrow_bold.png", 270.0)
}

fun EventTarget.backspaceIcon(): ImageView {
    return iconImageView("/assets/arrow_thin.png", 180.0)
}

fun EventTarget.iconImageView(iconUri: String, rotation: Double = 0.0): ImageView {
    return imageview(iconUri) {
        fitWidth = 50.0
        fitHeight = 50.0
        rotate = rotation
    }
}
