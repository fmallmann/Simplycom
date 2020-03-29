package de.fma.simplycom.board.model

import javafx.beans.property.SimpleStringProperty

class Board(text: String = "") {
    val text = SimpleStringProperty(this, "text", text)
}
