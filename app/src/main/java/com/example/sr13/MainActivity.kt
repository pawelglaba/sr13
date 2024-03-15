package com.example.sr13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var userInput: EditText
    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var nextViewButton: Button
    private var numTimesClicked = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicjalizacja elementów interfejsu użytkownika
        userInput = findViewById(R.id.inputName)
        button = findViewById(R.id.button)
        textView = findViewById(R.id.printText)

        textView.text = ""
        textView.movementMethod = ScrollingMovementMethod()

        nextViewButton = findViewById(R.id.nextView)

        // Obsługa kliknięcia przycisku "Next View"
        nextViewButton.setOnClickListener {
            openActivity2()
        }

        // Obsługa kliknięcia przycisku
        button.setOnClickListener {
            numTimesClicked++
            textView.append("\nThe button got tapped by ${userInput.text} $numTimesClicked time")
            if(numTimesClicked != 1){
                textView.append("s")
            }
        }
    }

    // Metoda do otwierania drugiej aktywności
    private fun openActivity2(){
        val intent = Intent(this, secondActivity::class.java)
        intent.putExtra("userName", userInput.text.toString())
        startActivity(intent)
    }
}
