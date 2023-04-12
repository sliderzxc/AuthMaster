package com.sliderzxc.authmaster.auth.signin

import com.sliderzxc.authmaster.auth.signin.data.UserSignInData
import com.sliderzxc.authmaster.auth.signin.repository.SignInRepository
import com.sliderzxc.authmaster.data.repository.AuthDataSource
import com.sliderzxc.authmaster.security.hashing.HashingService
import com.sliderzxc.authmaster.security.hashing.SaltedHash
import com.sliderzxc.authmaster.security.token.TokenService
import com.sliderzxc.authmaster.security.token.data.TokenClaim
import com.sliderzxc.authmaster.security.token.data.TokenConfig
import com.sliderzxc.authmaster.validation.signin.repository.SignInValidationRepository

class ManageSignIn(
    private val signInValidationRepository: SignInValidationRepository,
    private val authDataSource: AuthDataSource,
    private val hashingService: HashingService,
    private val tokenService: TokenService,
    private val tokenConfig: TokenConfig
) : SignInRepository {
    override suspend fun signIn(userSignInData: UserSignInData): Boolean {

        if (!signInValidationRepository.valid(userSignInData)) return false

        val user = authDataSource.getUserByEmail(userSignInData.email) ?: return false

        val isValidPassword = hashingService.verify(
            value = userSignInData.password,
            saltedHash = SaltedHash(
                hash = user.password,
                salt = user.salt
            )
        )

        if (!isValidPassword) return false

        val token = tokenService.generate(
            config = tokenConfig,
            TokenClaim(
                name = "userId",
                value = user.id.toString()
            )
        )

        return true
    }
}