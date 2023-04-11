package com.sliderzxc.authmaster.auth.signup.repository

import com.sliderzxc.authmaster.auth.signup.data.UserSignUpData

interface SignUpRepository {
    suspend fun signUp(userSignUpData: UserSignUpData): Boolean
}