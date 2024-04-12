package com.example.lab_exam

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
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