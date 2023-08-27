package com.qamar.mytaskscm.utils

import android.content.Context
import com.qamar.mytaskscm.TaskDb
import com.qamar.mytaskscm.data.repository.TaskRepository

actual class AppModule(context: Context) {
    actual val taskRepository: TaskRepository by lazy {
        TaskRepository(
            db = TaskDb(
                DatabaseDriverFactory(context = context).create()
            )
        )
    }
}