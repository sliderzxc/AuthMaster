package com.sliderzxc.authmaster.auth.signin.repository

import com.sliderzxc.authmaster.auth.signin.data.UserSignInData

interface SignInRepository {
    suspend fun signIn(userSignInData: UserSignInData): Boolean
}