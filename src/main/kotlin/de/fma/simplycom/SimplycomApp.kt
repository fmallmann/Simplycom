package de.fma.simplycom

import de.fma.simplycom.board.view.styles.BoardViewStyles
import de.fma.simplycom.common.components.styles.BoardComponentStyles
import de.fma.simplycom.main.views.MainView
import javafx.application.Application
import javafx.stage.Stage
import tornadofx.App

class MyApp : App(MainView::class, BoardViewStyles::class, BoardComponentStyles::class) {

    override fun start(stage: Stage) {
        super.start(stage)
        stage.isFullScreen = true
    }
}

/**
 * The main method is needed to support the mvn jfx:run goal.
 */
fun main(args: Array<String>) {
    Application.launch(MyApp::class.java, *args)
}
