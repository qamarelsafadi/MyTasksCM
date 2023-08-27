package com.qamar.mytaskscm.utils

import com.squareup.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {
     fun create(): SqlDriver
}