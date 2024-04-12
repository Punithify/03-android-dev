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
class MainActivity : AppCompatActivity() {
    private lateinit var sharedViewModel: BlankViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sharedViewModel = ViewModelProvider(this)[BlankViewModel::class.java]

        val bundle = Bundle()
        bundle.putString("hint", "Memory")
        val fragment = QFragment2()
        fragment.arguments = bundle

        findViewById<TextView>(R.id.textView).setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.frameLayout, QFragment1())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

            findViewById<TextView>(R.id.textView).text = "Reveal Answer?"
            findViewById<TextView>(R.id.textView).setOnClickListener{
                val fragmentTransaction2 = supportFragmentManager.beginTransaction()
                fragmentTransaction2.add(R.id.frameLayout, AFragment1())
                fragmentTransaction2.addToBackStack(null)
                fragmentTransaction2.commit()
                findViewById<TextView>(R.id.textView).text = "Next Joke(Intent) -->"
                findViewById<TextView>(R.id.textView).setOnClickListener{
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
