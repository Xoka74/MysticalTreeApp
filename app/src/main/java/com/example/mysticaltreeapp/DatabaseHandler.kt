package com.example.mysticaltreeapp

import java.sql.Connection
import java.sql.SQLException
import java.sql.Statement

class DatabaseHandler {
    private var _connection: Connection? = null
    private var _connectionResult: String = ""
    private var _isSuccess = false

    fun getList(table: String) : List<Map<String, String>>? {
        val data: List<Map<String, String>>? = null
        try{
            val helper = ConnectionHelper()
            _connection = helper.createConnection()
            if (_connection != null)
            {
                var query = "select * from $table"
                var statement: Statement = _connection!!.createStatement()
                val resultSet = statement.executeQuery(query)
                while(resultSet.next()){

                }
                _connectionResult="Success"
                _isSuccess=true
                _connection!!.close()
            }
            else
            {
                _connectionResult="Failed"
            }
        }
        catch(throwables: SQLException){
            throwables.printStackTrace()
        }
        return data
    }
}