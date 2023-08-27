package com.qamar.mytaskscm.ui

import com.qamar.mytaskscm.data.repository.TaskRepository
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class TaskViewModel(
    private val taskRepository: TaskRepository
) : ViewModel() {

    private val _state = MutableStateFlow(TaskState())

    val state = combine(
        _state,
        taskRepository.getTasks()
    ) { state, tasks ->
        state.copy(tasks = tasks)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), TaskState())

    fun addTask(title: String) {
        taskRepository.addTask(title)
    }

    fun deleteTask(id: Long) {
        taskRepository.deleteTask(id)
    }

}