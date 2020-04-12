package de.fma.simplycom.board.model

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty

class MailProperties(
        imapHostname: String = "",
        smtpHostname: String = "",
        port: Int = 443,
        username: String = "",
        password: String = "",
        enableSsl: Boolean = false
) {
    val imapHostname = SimpleStringProperty(this, "imapHostname", imapHostname)
    val smtpHostname = SimpleStringProperty(this, "smtpHostname", smtpHostname)
    val port = SimpleIntegerProperty(this, "port", port)
    val username = SimpleStringProperty(this, "username", username)
    val password = SimpleStringProperty(this, "password", password)
    val enableSsl = SimpleBooleanProperty(this, "enableSsl", enableSsl)
}
