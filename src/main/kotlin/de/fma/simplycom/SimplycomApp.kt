package de.fma.simplycom

import de.fma.simplycom.common.components.styles.BoardComponentStyles
import de.fma.simplycom.main.views.MainView
import de.fma.simplycom.board.view.styles.BoardViewStyles
import javafx.application.Application
import tornadofx.App

class MyApp: App(MainView::class, BoardViewStyles::class, BoardComponentStyles::class)

/**
 * The main method is needed to support the mvn jfx:run goal.
 */
fun main(args: Array<String>) {
    Application.launch(MyApp::class.java, *args)
}
