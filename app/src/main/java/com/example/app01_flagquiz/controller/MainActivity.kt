package com.example.app01_flagquiz.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app01_flagquiz.R
import com.example.app01_flagquiz.util.Constants

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etName = findViewById<EditText>(R.id.etName)
        val btnStart = findViewById<Button>(R.id.btnStart)

        btnStart.setOnClickListener {
            val name = etName.text.toString()
            if (name.isNotEmpty()) {
                val intent = Intent(this, QuizActivity::class.java)
                intent.putExtra(Constants.USER_NAME, name)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, digite seu nome", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
