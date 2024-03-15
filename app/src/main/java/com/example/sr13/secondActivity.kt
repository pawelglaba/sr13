package com.example.sr13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class secondActivity : AppCompatActivity() {

    private lateinit var backButton: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Odbieranie danych przekazanych z poprzedniej aktywności
        val userName = intent.getStringExtra("userName")

        // Inicjalizacja elementów interfejsu użytkownika
        textView = findViewById(R.id.printName)
        textView.text = userName

        backButton = findViewById(R.id.backButton)

        // Obsługa kliknięcia przycisku "Back"
        backButton.setOnClickListener {
            backActivity()
        }
    }

    // Metoda do powrotu do poprzedniej aktywności
    private fun backActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
