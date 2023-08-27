package com.qamar.mytaskscm.data.repository

import com.qamar.mytaskscm.TaskDb
import com.qamar.mytaskscm.data.model.Task
import com.qamar.mytaskscm.data.model.toTask
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskRepository(
    private val db: TaskDb
) {
    val queries = db.taskQueries

    fun getTasks(): Flow<List<Task>> {
        return queries.getTasks()
            .asFlow()
            .mapToList()
            .map {
                it.map {
                    it.toTask()
                }
            }
    }

    fun addTask(title: String) {
        queries.addTask(title = title, id = null)
    }

    fun deleteTask(id: Long) {
        queries.deleteTask(id = id)
    }


}