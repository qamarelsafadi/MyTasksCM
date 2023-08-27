package com.qamar.mytaskscm.utils

import android.content.Context
import com.qamar.mytaskscm.TaskDb
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(
            TaskDb.Schema,
            context = context,
            "task.db"
        )
    }
}