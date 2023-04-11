package com.sliderzxc.authmaster.validation.signup

import com.sliderzxc.authmaster.auth.signup.data.UserSignUpData
import com.sliderzxc.authmaster.validation.signup.repository.SignUpValidationRepository

class SignUpValidation : SignUpValidationRepository {
    override fun valid(userSignUpData: UserSignUpData): Boolean {
        val a = validEmail(userSignUpData.email)
        val b = validUsername(userSignUpData.username.toString())
        val c = validPasswords(userSignUpData.password, userSignUpData.confirmPassword.toString())
        return a == b == c
    }

    override fun validEmail(email: String): Boolean {
        if (!email.contains('@')) return false
        if (!email.contains('.')) return false
        return true
    }

    override fun validPasswords(password: String, confirmPassword: String): Boolean {
        if (password != confirmPassword) return false
        if (password.isBlank()) return false
        if (password.length < 6) return false
        return true
    }

    override fun validUsername(username: String): Boolean {
        if (username.isBlank()) return false
        if (username.length <= 3) return false
        return true
    }
}