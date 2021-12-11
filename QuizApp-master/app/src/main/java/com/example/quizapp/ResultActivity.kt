package com.example.quizapp;

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_quiz_result.*

class ResultActivity : AppCompatActivity(), View.OnClickListener {

        private var points: Int = 0

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_quiz_result)
                points = intent.getIntExtra("points", 0)
                tv_result.text = "$points/10"

        btn_submit.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
                when (v?.id) {
                        R.id.btn_submit -> {
                                val intent = Intent(this,MainActivity::class.java)
                                startActivity(intent)
                                finish()
                        }
                }
        }

}
