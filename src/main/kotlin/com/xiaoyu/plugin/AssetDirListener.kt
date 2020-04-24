package com.xiaoyu.plugin

import com.intellij.openapi.components.ProjectComponent
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.openapi.vfs.newvfs.BulkFileListener
import com.intellij.openapi.vfs.newvfs.events.VFileEvent


class AssetDirListener(private var project: Project) : ProjectComponent, BulkFileListener {

    override fun getComponentName(): String {
        return "com.xiaoyu.plugin.com.xiaoyu.plugin.AssetDirListener.Plugin"
    }

    override fun initComponent() {
        project.messageBus.connect().subscribe(VirtualFileManager.VFS_CHANGES, this)
    }

    override fun after(events: MutableList<out VFileEvent>) {
        //如果改动的文件是Assets下的文件
        if (events.any { it.file!!.path.contains("assets/") }) {
            generateCode(project)
        }
    }

}