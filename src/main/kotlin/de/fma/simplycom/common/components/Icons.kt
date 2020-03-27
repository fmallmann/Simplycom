package de.fma.simplycom.common.components

import javafx.event.EventTarget
import javafx.scene.image.ImageView
import tornadofx.imageview

enum class Icons {
    ENTER,
    SHIFT,
    BACKSPACE,
    EMAIL,
    QUIT
}

fun EventTarget.icon(icon: Icons): ImageView {
    return when (icon) {
        Icons.ENTER -> enterIcon()
        Icons.SHIFT -> shiftIcon()
        Icons.BACKSPACE -> backspaceIcon()
        Icons.EMAIL -> emailIcon()
        Icons.QUIT -> quitIcon()
    }
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
        fitWidth = 70.0
        fitHeight = 70.0
        rotate = rotation
    }
}
