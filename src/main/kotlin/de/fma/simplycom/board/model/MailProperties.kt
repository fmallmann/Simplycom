package de.fma.simplycom.board.model

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty

class MailProperties(
        hostname: String = "",
        port: Int = 443,
        username: String = "",
        password: String = "",
        enableSsl: Boolean = false
) {
    val hostname = SimpleStringProperty(this, "hostname", hostname)
    val port = SimpleIntegerProperty(this, "port", port)
    val username = SimpleStringProperty(this, "username", username)
    val password = SimpleStringProperty(this, "password", password)
    val enableSsl = SimpleBooleanProperty(this, "enableSsl", enableSsl)
}
