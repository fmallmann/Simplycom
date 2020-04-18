package de.fma.simplycom.mail.model

import javafx.beans.property.SimpleStringProperty

class SendMail(receiver: String? = null, text: String = "", subject: String = "") {

    val receiver = SimpleStringProperty(this, "receiver", receiver)
    val subject = SimpleStringProperty(this, "subject", subject)
    val text = SimpleStringProperty(this, "text", text)
}
