package de.fma.simplycom.board.controller

import de.fma.simplycom.board.model.Board
import javafx.application.Platform
import tornadofx.Controller
import kotlin.system.exitProcess

class BoardController : Controller() {

    fun close() {
        Platform.exit();
        exitProcess(0);
    }

    fun deleteAll(board: Board) {
        board.text = ""
    }
}
