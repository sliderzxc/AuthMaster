package com.sliderzxc.authmaster.data.entities

import org.bson.types.ObjectId

data class UserMongoData(
    val email: String,
    val password: String,
    val username: String? = null,
    val salt: String,
    val id: ObjectId = ObjectId()
)
