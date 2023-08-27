package com.qamar.mytaskscm.utils

import com.qamar.mytaskscm.data.repository.TaskRepository

expect class AppModule {
    val taskRepository: TaskRepository
}