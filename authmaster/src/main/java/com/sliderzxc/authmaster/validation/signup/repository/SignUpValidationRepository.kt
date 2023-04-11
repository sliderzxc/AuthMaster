package com.sliderzxc.authmaster.validation.signup.repository

import com.sliderzxc.authmaster.auth.signup.data.UserSignUpData

interface SignUpValidationRepository {

    fun valid(userSignUpData: UserSignUpData): Boolean

    fun validEmail(email: String): Boolean

    fun validPasswords(password: String, confirmPassword: String): Boolean

    fun validUsername(username: String): Boolean
}