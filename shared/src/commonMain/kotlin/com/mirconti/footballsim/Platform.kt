package com.mirconti.footballsim

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform