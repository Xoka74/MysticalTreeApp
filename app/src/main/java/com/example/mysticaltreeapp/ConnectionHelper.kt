package com.example.mysticaltreeapp

import android.annotation.SuppressLint
import android.os.StrictMode
import android.util.Log
import java.sql.Connection
import java.sql.DriverManager

class ConnectionHelper {
    private var _ip: String = "127.0.0.1"
    private var _port: String = "3306"
    private var _db: String = "mystical_tree_bd"
    private var _username: String = "root"
    private var _password: String = ""

    @SuppressLint("NewApi")
    fun createConnection(): Connection? {

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var connection: Connection? = null
        try {
            Class.forName("net.sourceforge.jtdc.jdbc.Driver")
            val connectURL = buildUrl(_ip, _port, _db, _username, _password)
            connection = DriverManager.getConnection(connectURL)
        } catch (exception: Exception) {
            Log.e("Error: ", exception.message.toString())
        }
        return connection
    }

    private fun buildUrl(
        ip: String,
        port: String,
        db: String,
        username: String,
        password: String
    ): String
    {
        return "jdbc:jtdc:sqlserver://" + ip + ":" + port + ";" +
                "databaseName=" + db + ";user=" + username + ";password=" + password + ";"
    }
}