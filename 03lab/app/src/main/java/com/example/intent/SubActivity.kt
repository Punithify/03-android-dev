package com.example.intent

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import android.widget.TimePicker
import java.util.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class SubActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sub_activity)
        val extras = intent.extras
        val value = extras?.getString("username")

        val toolbar:MaterialToolbar = findViewById(R.id.toolbar)
        toolbar.title = "Hello $value"
        val showAlertButton: Button = findViewById(R.id.showAlertButton)
        showAlertButton.setOnClickListener {
            showAlertDialog()
        }
        // Spinner
//        val spinnerItems = listOf("Item 1", "Item 2", "Item 3", "Item 4")
//        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerItems)
//        val spinner = findViewById<Spinner>(R.id.spinner)
//        spinner.setAdapter(spinnerAdapter)
//
//        spinner.onItemClickListener =
//            AdapterView.OnItemClickListener { _, _, position, _ ->
//                val selectedItem = spinnerAdapter.getItem(position).toString()
//                // Do something with the selected item
//            }

        // Date-Time Picker
        val buttonDateTime = findViewById<Button>(R.id.buttonDateTime)
        buttonDateTime.setOnClickListener {
            showDateTimePicker()
        }
    }
    private fun showDateTimePicker() {
        val currentDateTime = Calendar.getInstance()
        val year = currentDateTime.get(Calendar.YEAR)
        val month = currentDateTime.get(Calendar.MONTH)
        val day = currentDateTime.get(Calendar.DAY_OF_MONTH)
        val hour = currentDateTime.get(Calendar.HOUR_OF_DAY)
        val minute = currentDateTime.get(Calendar.MINUTE)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
                val calendar = Calendar.getInstance()
                calendar.set(selectedYear, selectedMonth, selectedDay)

                TimePickerDialog(
                    this,
                    TimePickerDialog.OnTimeSetListener { _: TimePicker?, selectedHour: Int, selectedMinute: Int ->
                        calendar.set(Calendar.HOUR_OF_DAY, selectedHour)
                        calendar.set(Calendar.MINUTE, selectedMinute)

                        // Do something with the selected date-time
                    },
                    hour,
                    minute,
                    true
                ).show()
            },
            year,
            month,
            day
        )

        datePickerDialog.datePicker.minDate = System.currentTimeMillis() - 1000
        datePickerDialog.show()
    }
    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert Dialog Title")
            .setMessage("This is a sample alert dialog.")
            .setPositiveButton("OK") { dialog, _ ->
                // Handle positive button click
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                // Handle negative button click
                dialog.dismiss()
            }
            .setCancelable(false) // Optional: Prevent dialog dismissal when touching outside

        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}