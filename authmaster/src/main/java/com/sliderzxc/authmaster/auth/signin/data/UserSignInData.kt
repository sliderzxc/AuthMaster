package com.sliderzxc.authmaster.auth.signin.data

data class UserSignInData(
    val email: String,
    val username: String? = null,
    val password: String
)