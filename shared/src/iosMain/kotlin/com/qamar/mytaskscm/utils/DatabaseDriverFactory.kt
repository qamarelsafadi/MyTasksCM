package com.qamar.mytaskscm.utils

import com.qamar.mytaskscm.TaskDb
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(
            TaskDb.Schema,
            "task.db"
        )
    }
}