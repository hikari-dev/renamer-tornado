package dev.hikari.view

import dev.hikari.controller.MainController
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Insets
import javafx.geometry.Pos
import tornadofx.*

class MainView : View("🐂啊") {

    private val controller by inject<MainController>()

    override val root = form {
        val path = SimpleStringProperty()
        val target = SimpleStringProperty()
        val replacement = SimpleStringProperty()
        fieldset {
            alignment = Pos.CENTER
            padding = Insets(10.0)
            field {
                text = "文件夹路径"
                textfield(path)
            }
            field {
                text = "替换目标"
                textfield(target)
            }
            field {
                text = "替换内容"
                textfield(replacement)
            }
            button("确定") {
                action {
                    if (path.value.isNullOrEmpty() || target.value.isNullOrEmpty()) {
                        warning("提示", "路径和替换目标必填哦")
                    } else {
                        controller.changeFilename(path.value, target.value, replacement.value ?: "")
                    }
                }
            }
        }
    }

}