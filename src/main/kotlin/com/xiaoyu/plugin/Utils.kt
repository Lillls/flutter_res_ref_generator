package com.xiaoyu.plugin

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import java.io.File

const val dartFile = "r.dart"
const val assetsDir = "assets"
const val sourceDir = "lib"


fun write2DartFile(parent: File, assetsStr: List<String>) {
    val file = File(parent.path, dartFile)
    file.writeText("class R {")
    file.appendText("\n")
    assetsStr.forEach {
        file.appendText("  ")
        file.appendText("static const ")
        file.appendText(it.replace("/", "_").split(".")[0])
        file.appendText(" = ")
        file.appendText(""""""")
        file.appendText(it.replace("$", "\\$"))
        file.appendText(""""""")
        file.appendText(";")
        file.appendText("\n")
    }
    file.appendText("}")
}


fun generateCode(project: Project) {
    //拿到lib目录
    val libFileDir = File(project.basePath, sourceDir)
    //拿到assets目录 TODO 后期考虑自己设置目录
    val assetsDir = File(project.basePath, assetsDir)
    if (!libFileDir.exists()) {
        Messages.showMessageDialog(
            project,
            "$sourceDir don't exists",
            "Failure",
            Messages.getInformationIcon()
        )
        return
    }

    if (!assetsDir.exists()) {
        Messages.showMessageDialog(
            project,
            "$assetsDir don't exists",
            "Failure",
            Messages.getInformationIcon()
        )
        return
    }
    //拿到assets目录所有以png和jpg的所有文件
    val assetsFiles = mutableListOf<File>()
    val assetsWalk = assetsDir.walk()
    assetsWalk.iterator().forEach { assetsFiles.add(it) }
    //将文件转为String路径
    val assetsPath = assetsFiles.filter {
        it.name.endsWith(".png") || it.name.endsWith(".jpg")
    }
        .filter {
            val regex = Regex("[a-zA-Z_\$][a-zA-Z0-9_\$]*")
            it.name.replace(".png", "")
                .replace(".jpg", "")
                .matches(regex)
        }
        .map { "$assetsDir/" + it.path.split("$assetsDir/".toRegex(), 2)[1] }
    //开始生产代码
    write2DartFile(libFileDir, assetsPath)
}
