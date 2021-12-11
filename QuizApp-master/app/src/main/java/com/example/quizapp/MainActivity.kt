package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //onCreate funkcja wykonująca się przy otwarciu bieżącej aktywności
    //savedInstanceState pozwala na zapisanie danych w pamięci ulotnej. Przydaje się np. przy minimalizacji aplikacji
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Przydzielenie layoutu, dla aktualnej aktywności
        setContentView(R.layout.activity_main)

        //Ustawianie zmiany aktywności, po wciśnięciu przycisku i zamknięcie aktualnej
        btn_start.setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}