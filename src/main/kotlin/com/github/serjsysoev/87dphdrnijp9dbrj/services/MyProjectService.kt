package com.github.serjsysoev.87dphdrnijp9dbrj.services

import com.intellij.openapi.project.Project
import com.github.serjsysoev.87dphdrnijp9dbrj.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
