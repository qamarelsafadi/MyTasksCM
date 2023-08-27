package com.qamar.mytaskscm

import com.qamar.mytaskscm.platform.Platform
import com.qamar.mytaskscm.platform.getPlatform

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}