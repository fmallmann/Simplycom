package de.fma.simplycom.mail.model

import javafx.beans.property.SimpleStringProperty

class SendMail(text: String = "", subject: String = "") {

    val subject = SimpleStringProperty(this, "subject", subject)
    val text = SimpleStringProperty(this, "text", text)
}
