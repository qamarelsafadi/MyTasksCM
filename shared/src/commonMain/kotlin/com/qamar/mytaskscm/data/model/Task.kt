package com.qamar.mytaskscm.data.model

import database.TaskEntity

data class Task(val id: Long? = null, val title: String)

fun TaskEntity.toTask(): Task {
    return Task(
        id = id,
        title = title
    )
}
