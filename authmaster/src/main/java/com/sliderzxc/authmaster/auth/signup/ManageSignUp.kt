package com.sliderzxc.authmaster.auth.signup

import com.sliderzxc.authmaster.auth.signup.data.UserSignUpData
import com.sliderzxc.authmaster.auth.signup.repository.SignUpRepository
import com.sliderzxc.authmaster.data.entities.UserMongoData
import com.sliderzxc.authmaster.data.repository.AuthDataSource
import com.sliderzxc.authmaster.security.hashing.HashingService
import com.sliderzxc.authmaster.validation.signup.repository.SignUpValidationRepository

class ManageSignUp(
    private val signUpValidationRepository: SignUpValidationRepository,
    private val authDataSource: AuthDataSource,
    private val hashingService: HashingService
) : SignUpRepository {
    override suspend fun signUp(userSignUpData: UserSignUpData): Boolean {

        if (!signUpValidationRepository.valid(userSignUpData)) return false

        val saltedHash = hashingService.generateSaltedHash(userSignUpData.password)
        val userMongoData = UserMongoData(
            email = userSignUpData.email,
            password = saltedHash.hash,
            username = userSignUpData.username,
            salt = saltedHash.salt
        )

        return authDataSource.addUser(userMongoData)
    }
}