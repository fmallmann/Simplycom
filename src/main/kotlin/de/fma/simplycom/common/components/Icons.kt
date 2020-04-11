package de.fma.simplycom.common.components

import javafx.event.EventTarget
import javafx.scene.image.ImageView
import tornadofx.imageview

enum class Icons {
    ENTER,
    SHIFT,
    BACKSPACE,
    EMAIL,
    SEND_MAIL,
    QUIT,
    ALL_SCROLL_UP,
    ALL_SCROLL_DOWM,
    SCROLL_UP,
    SCROLL_DOWN,
    TRASH,
    CLOSE,
    INBOX,
    OUTBOX,
    CONTACTS,
    ADRESSES,
    CHOOSE_FILE,
    ANSWER,
    ANSWER_ALL,
    FORWARD,
    ADD,
    PREFERENCES,
    CHECKMARK
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
        Icons.CLOSE -> closeIcon()
        Icons.SEND_MAIL -> sendMailIcon()
        Icons.INBOX -> inboxIcon()
        Icons.OUTBOX -> outboxIcon()
        Icons.CONTACTS -> contactsIcon()
        Icons.ADRESSES -> adressesIcon()
        Icons.CHOOSE_FILE -> chooseFileIcon()
        Icons.ANSWER -> answerIcon()
        Icons.ANSWER_ALL -> answerAllIcon()
        Icons.FORWARD -> forwardIcon()
        Icons.ADD -> addIcon()
        Icons.PREFERENCES -> preferencesIcon()
        Icons.CHECKMARK -> checkmarkIcon()
    }
}

fun EventTarget.checkmarkIcon(): ImageView = iconImageView("/assets/checkmark.png")

fun EventTarget.preferencesIcon(): ImageView = iconImageView("/assets/preferences.png")

fun EventTarget.answerIcon(): ImageView = iconImageView("/assets/answer.png")

fun EventTarget.answerAllIcon(): ImageView = iconImageView("/assets/answer_all.png")

fun EventTarget.forwardIcon(): ImageView = iconImageView("/assets/forward.png")

fun EventTarget.addIcon(): ImageView = iconImageView("/assets/add.png")

fun EventTarget.chooseFileIcon(): ImageView = iconImageView("/assets/choose_file.png")

fun EventTarget.adressesIcon(): ImageView = iconImageView("/assets/adresses.png")

fun EventTarget.inboxIcon(): ImageView = iconImageView("/assets/inbox.png")

fun EventTarget.outboxIcon(): ImageView = iconImageView("/assets/outbox.png")

fun EventTarget.contactsIcon(): ImageView = iconImageView("/assets/contacts.png")

fun EventTarget.sendMailIcon(): ImageView = iconImageView("/assets/send_mail.png")

fun EventTarget.closeIcon(): ImageView = iconImageView("/assets/close.png")

fun EventTarget.trashIcon(): ImageView = iconImageView("/assets/trash.png")

fun EventTarget.scrollUpIcon(): ImageView = iconImageView("/assets/scroll.png", 180.0)

fun EventTarget.allScrollUpIcon(): ImageView = iconImageView("/assets/all_scroll.png", 180.0)

fun EventTarget.scrollDownIcon(): ImageView = iconImageView("/assets/scroll.png")

fun EventTarget.allScrollDownIcon(): ImageView = iconImageView("/assets/all_scroll.png")

fun EventTarget.quitIcon(): ImageView = iconImageView("/assets/quit.png")

fun EventTarget.enterIcon(): ImageView = iconImageView("/assets/enter.png")

fun EventTarget.emailIcon(): ImageView = iconImageView("/assets/email.png")

fun EventTarget.shiftIcon(): ImageView = iconImageView("/assets/arrow_bold.png", 270.0)

fun EventTarget.backspaceIcon(): ImageView = iconImageView("/assets/arrow_thin.png", 180.0)

fun EventTarget.iconImageView(iconUri: String, rotation: Double = 0.0): ImageView {
    return imageview(iconUri) {
        fitWidth = 50.0
        fitHeight = 50.0
        rotate = rotation
    }
}
