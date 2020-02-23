package de.fma.simplycom.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class Board(text: String = "") {

    val textProperty = SimpleStringProperty(this,"text", text)
    var text by textProperty
}
