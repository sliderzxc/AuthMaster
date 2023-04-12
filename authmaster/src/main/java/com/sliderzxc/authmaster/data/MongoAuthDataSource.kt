package com.sliderzxc.authmaster.data

import com.sliderzxc.authmaster.data.entities.UserMongoData
import com.sliderzxc.authmaster.data.repository.AuthDataSource
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.eq

class MongoAuthDataSource(database: CoroutineDatabase) : AuthDataSource {
    private val users = database.getCollection<UserMongoData>()

    override suspend fun addUser(userMongoData: UserMongoData): Boolean {
        return users.insertOne(userMongoData).wasAcknowledged()
    }

    override suspend fun getUserByEmail(mail: String): UserMongoData? {
        return users.findOne(UserMongoData::email eq mail)
    }
}