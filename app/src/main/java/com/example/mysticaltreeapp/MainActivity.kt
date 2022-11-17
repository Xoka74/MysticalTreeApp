package com.example.mysticaltreeapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = DatabaseHandler()
        val pictures = db.getList("pictures")
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = pictures.toString()
    }
}