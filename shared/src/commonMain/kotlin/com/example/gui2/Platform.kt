package com.example.gui2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform