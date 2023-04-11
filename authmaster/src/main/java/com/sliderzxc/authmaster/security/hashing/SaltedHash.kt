package com.sliderzxc.authmaster.security.hashing

data class SaltedHash(
    val hash: String,
    val salt: String
)
