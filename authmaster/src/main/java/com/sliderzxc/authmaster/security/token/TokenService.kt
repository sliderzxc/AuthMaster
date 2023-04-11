package com.sliderzxc.authmaster.security.token

import com.sliderzxc.authmaster.security.token.data.TokenClaim
import com.sliderzxc.authmaster.security.token.data.TokenConfig

interface TokenService {
    fun generate(
        config: TokenConfig,
        vararg claims: TokenClaim
    ): String
}