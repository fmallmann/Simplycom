package de.fma.simplycom.board.controller

import de.fma.simplycom.board.model.Board
import javafx.application.Platform
import tornadofx.Controller
import kotlin.system.exitProcess

class BoardController : Controller() {

    val board = Board()

    fun close() {
        Platform.exit();
        exitProcess(0);
    }
}
