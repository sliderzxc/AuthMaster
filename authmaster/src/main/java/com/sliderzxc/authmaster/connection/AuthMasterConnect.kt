package com.sliderzxc.authmaster.connection

import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

object AuthMasterConnect {
    fun connect(connectionData: ConnectionData): CoroutineDatabase {
        val mongoClient = KMongo.createClient(connectionData.formatConnectString())
        return mongoClient.coroutine.getDatabase(connectionData.dbName)
    }
}