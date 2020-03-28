package de.fma.simplycom.board.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.ItemViewModel
import tornadofx.getValue
import tornadofx.setValue

class BoardModel(board: Board) : ItemViewModel<Board>(board) {
    val text = bind(Board::textProperty)
}

class Board(text: String = "") {

    val textProperty = SimpleStringProperty(this, "text", text)
    var text by textProperty
}
