package de.fma.simplycom.board.view

import de.fma.simplycom.board.components.boardTextArea
import de.fma.simplycom.board.viewmodel.BoardViewModel
import de.fma.simplycom.common.components.Icons
import de.fma.simplycom.common.components.iconButton
import de.fma.simplycom.common.components.scrollButtons
import javafx.scene.control.TextArea
import tornadofx.View
import tornadofx.action
import tornadofx.borderpane
import tornadofx.bottom
import tornadofx.center
import tornadofx.hbox
import tornadofx.left
import tornadofx.right
import tornadofx.singleAssign
import tornadofx.top
import tornadofx.vbox

class BoardView : View("Board") {

    private val vm: BoardViewModel by inject()
    private var textArea: TextArea by singleAssign()

    override val root = borderpane {
        center {
            textArea = boardTextArea(vm.board.text)
        }
        left {
            vbox {
                hbox {
                    iconButton(Icons.TRASH) {
                        action { vm.deleteAll() }
                    }
                    iconButton(Icons.PREFERENCES) {
                        action { replaceWith<PreferencesView>() }
                    }
                }
            }
        }
        right {
            borderpane {
                top {
                    iconButton(Icons.QUIT) {
                        action {
                            vm.close()
                        }
                    }
                }
                bottom {
                    scrollButtons(textArea)
                }
            }
        }
    }
}

