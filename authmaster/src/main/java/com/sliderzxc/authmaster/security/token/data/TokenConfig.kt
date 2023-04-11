package com.sliderzxc.authmaster.security.token.data

data class TokenConfig(
    val issuer: String,
    val audience: String,
    val expiresIn: Long,
    val secret: String
)
