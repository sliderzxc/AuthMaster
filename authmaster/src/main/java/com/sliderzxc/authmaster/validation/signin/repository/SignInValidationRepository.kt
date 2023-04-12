package com.sliderzxc.authmaster.validation.signin.repository

import com.sliderzxc.authmaster.auth.signin.data.UserSignInData

interface SignInValidationRepository {

    fun valid(userSignInData: UserSignInData): Boolean

    fun validPassword(password: String): Boolean

    fun validEmail(email: String): Boolean

    fun validUsername(username: String): Boolean
}