package dev.hikari

import dev.hikari.view.MainView
import javafx.scene.image.Image
import javafx.stage.Stage
import tornadofx.App

class RenamerApp : App(MainView::class) {

    override fun start(stage: Stage) {
        super.start(stage)
        stage.icons.add(Image("567.jpeg"))
    }
}