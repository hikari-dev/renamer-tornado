package dev.hikari.controller

import tornadofx.Controller
import tornadofx.information
import java.io.File

class MainController : Controller() {

    fun changeFilename(path: String, target: String, replacement: String) {
        val dir = File(path)
        if (!dir.isDirectory) {
            tornadofx.error("路径要是个文件夹路径啊喂！")
            return
        }
        dir.walk()
            .maxDepth(1)
            .drop(1)
            .forEach {
                if (it.isFile && it.name.contains(target)) {
                    val newName = it.name.replaceFirst(target, replacement)
                    if (it.renameTo(File(path, newName))) {
                        println("${it.name} has been renamed to $newName")
                    } else {
                        println("${it.name} rename failed")
                    }
                }
            }
        information("提示", "已完成")
    }
}