package com.main.authmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sliderzxc.authmaster.connection.ConnectionData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val connectionData = ConnectionData(
            "grinikvadim0",
            "password",
            "cluster0",
            "clusterId",
            "DatabaseUsers"
        )
    }
}