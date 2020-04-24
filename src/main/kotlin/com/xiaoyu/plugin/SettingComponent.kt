package com.xiaoyu.plugin

import com.intellij.openapi.options.Configurable
import com.sun.tools.javac.tree.JCTree
import java.awt.Color
import net.miginfocom.layout.LinkHandler.setBounds
import com.intellij.uiDesigner.core.Util.getPreferredSize
import java.awt.Dimension
import java.awt.Font
import javax.swing.*
import javax.swing.JPasswordField
import javax.swing.JPanel


class SettingComponent : Configurable {
    override fun isModified(): Boolean {
        return true
    }

    override fun getDisplayName(): String {
        return "Flutter Resources Reference Generator Setting"
    }

    override fun apply() {

    }

    override fun createComponent(): JComponent? {
        val container = JPanel()
        val panel01 = JPanel()
        panel01.add(JLabel("用户名"))
        panel01.add(JTextField(10))

        val panel02 = JPanel()
        panel02.add(JLabel("密   码"))
        panel02.add(JPasswordField(10))
        container.add(panel01)
        container.add(panel02)
        return container
    }

}