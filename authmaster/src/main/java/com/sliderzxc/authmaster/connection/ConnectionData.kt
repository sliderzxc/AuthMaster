package com.sliderzxc.authmaster.connection

data class ConnectionData(
    val username: String,
    val password: String,
    val clusterName: String = "cluster0",
    val clusterId: String,
    val dbName: String
) {
    fun formatConnectString(): String {
        return "mongodb+srv://$username:$password@$clusterName.$clusterId.mongodb.net/$dbName?retryWrites=true&w=majority"
    }
}