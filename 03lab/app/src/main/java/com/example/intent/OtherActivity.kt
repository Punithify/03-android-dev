package com.example.intent

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.Snackbar

class OtherActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        val extras = intent.extras
        val value = extras?.getString("name")
        val parentLayout = findViewById<View>(android.R.id.content)
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .build()
        val snackbar = Snackbar.make(parentLayout, "Hello$value", Snackbar.LENGTH_SHORT)
        snackbar.show()

    }
}