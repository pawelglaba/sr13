
package com.example.sr13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Deklaracja obiektow
    private var userInput: EditText? = null
    private var pushButton: Button? = null
    private var textView: TextView? = null
    private var nextViewButton: Button? = null
    private var numTimesClicked = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ustawienie widoku interfejsu użytkownika na activity_main.xml
        setContentView(R.layout.activity_main)
        // Inicjalizacja elementów interfejsu użytkownika
        userInput = findViewById(R.id.inputName)
        pushButton = findViewById(R.id.pushButton)
        textView = findViewById(R.id.printText)

        textView?.text = resources.getString(R.string.helloWorld)
        // Ustawienie przewijania w TextView
        textView?.movementMethod = ScrollingMovementMethod()

        // Inicjalizacja przycisku przejścia do kolejnej aktywności
        nextViewButton = findViewById(R.id.nextView)

        // Ustawienie nasłuchiwacza zdarzeń dla przycisku przejścia do kolejnej aktywności
        nextViewButton?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                openSecondActivity()
            }
        })

        // Ustawienie nasłuchiwacza zdarzeń dla przycisku
        pushButton?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                numTimesClicked += 1
                textView?.append("\n The button got tapped by ${userInput?.text} $numTimesClicked time")
                if(numTimesClicked !=1){
                    textView?.append("s")
                }
            }
        })
    }

    // Metoda otwierająca drugą aktywność
    private fun openSecondActivity(){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("name",userInput?.text.toString())
        startActivity(intent)
    }
}
