package de.fma.simplycom

import de.fma.simplycom.components.styles.BoardComponentStyles
import de.fma.simplycom.views.BoardView
import de.fma.simplycom.views.styles.BoardViewStyles
import javafx.application.Application
import tornadofx.App

class MyApp: App(BoardView::class, BoardViewStyles::class, BoardComponentStyles::class)

/**
 * The main method is needed to support the mvn jfx:run goal.
 */
fun main(args: Array<String>) {
    Application.launch(MyApp::class.java, *args)
}
