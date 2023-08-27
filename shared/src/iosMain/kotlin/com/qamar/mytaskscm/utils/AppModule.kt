package com.qamar.mytaskscm.utils

import com.qamar.mytaskscm.TaskDb
import com.qamar.mytaskscm.data.repository.TaskRepository

actual class AppModule {
    actual val taskRepository: TaskRepository by lazy {
        TaskRepository(
            db = TaskDb(
                DatabaseDriverFactory().create()
            )
        )
    }
}