package com.example.testproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InputActivity : AppCompatActivity() {
    private lateinit var etTitle: EditText
    private lateinit var etText: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_input)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etTitle = findViewById(R.id.etTitle)
        etText = findViewById(R.id.etText)
        btnSave = findViewById(R.id.btnSave)

        btnSave.setOnClickListener {
            val intent = Intent(this, ShowActivity::class.java)
            intent.putExtra("msg", "title: ${etTitle.text.trim()}, text: ${etText.text.trim()}")
            startActivity(intent)
        }
    }
}