package de.fma.simplycom.board.viewmodel

import de.fma.simplycom.board.model.Board
import javafx.application.Platform
import tornadofx.ViewModel
import kotlin.system.exitProcess

class BoardViewModel : ViewModel() {

    val board = Board()

    fun close() {
        Platform.exit();
        exitProcess(0);
    }

    fun deleteAll() {
        board.text.value = ""
    }
}
