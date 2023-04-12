package com.sliderzxc.authmaster.validation.signin

import com.sliderzxc.authmaster.auth.signin.data.UserSignInData
import com.sliderzxc.authmaster.validation.signin.repository.SignInValidationRepository

class SignInValidation : SignInValidationRepository {
    override fun valid(userSignInData: UserSignInData): Boolean {
        val a = validEmail(userSignInData.email)
        val b = validPassword(userSignInData.password)
        val c = validUsername(userSignInData.username.toString())
        return a == b == c
    }

    override fun validPassword(password: String): Boolean {
        if (password.isBlank()) return false
        if (password.length < 6) return false
        return true
    }

    override fun validEmail(email: String): Boolean {
        if (!email.contains('@')) return false
        if (!email.contains('.')) return false
        return true
    }

    override fun validUsername(username: String): Boolean {
        if (username.isBlank()) return false
        if (username.length <= 3) return false
        return true
    }
}