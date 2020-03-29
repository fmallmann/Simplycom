package de.fma.simplycom.board.viewmodel

import de.fma.simplycom.board.model.Board
import de.fma.simplycom.common.components.BackspaceButtonClicked
import de.fma.simplycom.common.components.LetterButtonCliecked
import javafx.application.Platform
import tornadofx.ViewModel
import kotlin.system.exitProcess

class BoardViewModel : ViewModel() {

    val board = Board()

    init {
        subscribe<LetterButtonCliecked> {
            board.text.value += it.letter
        }
        subscribe<BackspaceButtonClicked> {
            removeLast()
        }
    }

    fun close() {
        Platform.exit();
        exitProcess(0);
    }

    fun deleteAll() {
        board.text.value = ""
    }

    fun removeLast() {
        board.text.value = if (board.text.value.isNotEmpty()) board.text.value.substring(0 until board.text.value.length - 1) else ""
    }
}
