package com.example.intent

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView (R.layout.activity_main)
        findViewById<Button>(R.id.buttonLogin).setOnClickListener{
            val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
            val username = editTextUsername.text.toString()
            val intent = Intent(this, SubActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            intent.putExtra("username", username)
            Log.d(TAG, "Clicked ")
            startActivity(intent)

        }

    }
}