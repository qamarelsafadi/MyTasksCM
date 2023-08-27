package com.qamar.mytaskscm

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.qamar.mytaskscm.data.model.Task
import com.qamar.mytaskscm.ui.TaskViewModel
import com.qamar.mytaskscm.utils.AppModule
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
fun App(appModule: AppModule) {
    val viewModel = getViewModel(
        "tasks-vm",
        factory = viewModelFactory {
            TaskViewModel(
                appModule.taskRepository
            )
        }
    )

    val state by viewModel.state.collectAsState()
    TasksScreen(
        state.tasks,
        onAddTask = viewModel::addTask,
        onDelete = viewModel::deleteTask
    )
}

@Composable
fun TasksScreen(
    tasks: List<Task>,
    onAddTask: (String) -> Unit,
    onDelete: (Long) -> Unit,
) {
    Scaffold {
        LazyColumn(
            Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                FieldView(onAddTask)
            }
            item {
                Text(
                    "My Tasks (${tasks.size})",
                    fontWeight = FontWeight.Bold
                )
            }
            items(tasks) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(it.title)
                    Icon(Icons.Default.Delete, contentDescription = "Delete",
                        modifier = Modifier.clickable {
                            it.id?.let { it1 -> onDelete(it1) }
                        })
                }
            }
        }
    }
}

@Composable
private fun FieldView(
    onAddTask: (String) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        var title by remember { mutableStateOf("") }
        OutlinedTextField(
            value = title,
            onValueChange = {
                title = it
            },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.weight(1f),
            placeholder = {
                Text("Write your task here")
            },
        )
        Button(
            onClick = {
                onAddTask(title)
                title = ""
            }
        ) {
            Text(text = "Save")
        }
    }
}
