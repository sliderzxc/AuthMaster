package com.sliderzxc.authmaster.data.repository

import com.sliderzxc.authmaster.data.entities.UserMongoData

interface AuthDataSource {

    suspend fun addUser(userMongoData: UserMongoData): Boolean

    suspend fun getUserByMail(mail: String): UserMongoData?
}