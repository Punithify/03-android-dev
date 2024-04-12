package com.example.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class MainActivity2 : AppCompatActivity() {
    private lateinit var sharedViewModel: BlankViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val bundle = Bundle()
        bundle.putString("hint", "Memory")
        val fragment = QFragment2()
        fragment.arguments = bundle

        sharedViewModel = ViewModelProvider(this)[BlankViewModel::class.java]

        findViewById<TextView>(R.id.textView).setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.frameLayout, QFragment2())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

            findViewById<TextView>(R.id.textView).text = "Reveal Answer?"
            findViewById<TextView>(R.id.textView).setOnClickListener{
                val fragmentTransaction2 = supportFragmentManager.beginTransaction()
                fragmentTransaction2.add(R.id.frameLayout, AFragment2())
                fragmentTransaction2.addToBackStack(null)
                fragmentTransaction2.commit()
                findViewById<TextView>(R.id.textView).text = "<---- Previous Joke(Intent)"
                findViewById<TextView>(R.id.textView).setOnClickListener{
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
