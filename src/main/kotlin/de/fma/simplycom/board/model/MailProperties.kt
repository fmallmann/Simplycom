package de.fma.simplycom.board.model

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty

class MailProperties(
        shownName: String = "",
        imapHostname: String = "",
        smtpHostname: String = "",
        imapPort: Int = 443,
        smtpPort: Int = 587,
        username: String = "",
        password: String = "",
        enableSsl: Boolean = false
) {
    val shownName = SimpleStringProperty(this, "shownName", shownName)
    val imapHostname = SimpleStringProperty(this, "imapHostname", imapHostname)
    val smtpHostname = SimpleStringProperty(this, "smtpHostname", smtpHostname)
    val imapPort = SimpleIntegerProperty(this, "imapPort", imapPort)
    val smtpPort = SimpleIntegerProperty(this, "smtpPort", smtpPort)
    val username = SimpleStringProperty(this, "username", username)
    val password = SimpleStringProperty(this, "password", password)
    val enableSsl = SimpleBooleanProperty(this, "enableSsl", enableSsl)
}
