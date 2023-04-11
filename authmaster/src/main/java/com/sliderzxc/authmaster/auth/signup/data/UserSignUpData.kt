package com.sliderzxc.authmaster.auth.signup.data

data class UserSignUpData(
    val email: String,
    val password: String,
    val confirmPassword: String? = null,
    val username: String? = null
)