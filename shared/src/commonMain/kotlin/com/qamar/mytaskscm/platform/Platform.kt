package com.qamar.mytaskscm.platform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform