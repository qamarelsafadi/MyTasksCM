package com.qamar.mytaskscm

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.qamar.mytaskscm.App
import com.qamar.mytaskscm.utils.AppModule

@Composable
fun Application(){
    App(AppModule(LocalContext.current))
}