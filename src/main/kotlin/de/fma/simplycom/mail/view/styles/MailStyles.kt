package de.fma.simplycom.mail.view.styles

import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.pt
import tornadofx.px

class MailStyles : Stylesheet() {
    companion object {
        val mailText by cssclass()
        val mailList by cssclass()
        val receiver by cssclass()
    }

    init {
        mailText {
            fontSize = 30.pt
            padding = box(5.px, 10.px)
        }

        mailList {
            fontSize = 24.pt
            listCell {
                padding = box(5.px, 10.px)
            }
        }

        receiver {
            fontSize = 20.pt
        }
    }
}
