package com.xiaoyu.plugin

import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.ui.Messages


class FlutterResRefGenerator : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val start = System.currentTimeMillis()
        val project = e.project
        generateCode(project!!)
        val end = System.currentTimeMillis()
        Messages.showMessageDialog(
            project,
            "Time consuming ${end - start} millis",
            "Flutter Resource Reference Generate Success",
            Messages.getInformationIcon()
        )

    }

}

