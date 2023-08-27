package com.qamar.mytaskscm

import androidx.compose.ui.window.ComposeUIViewController
import com.qamar.mytaskscm.utils.AppModule

fun MainViewController() = ComposeUIViewController { App(AppModule()) }