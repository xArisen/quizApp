package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*
import kotlinx.android.synthetic.main.activity_quiz_questions.btn_submit

//View.OnClickListener umożliwia korzystanie z onClick() i setOnClickListener()
class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var points: Int = 0
    private var optionSelected: Boolean = false
    private var optionLocked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mQuestionList = Constants.getQuestions()
        setQuestion()

        //Przypisanie przyciskowi oczekiwania na wciśnięcie przez użytkownika
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    //Przygotowanie podstawowego wyglądu widoku i danych, po przejsciu do nowego pytania
    private fun setQuestion() {

        val question = mQuestionList!!.get(mCurrentPosition - 1)

        //ustawia podstawowy wygląd przycisków
        defaultOptionsView()

        btn_submit.text = "Potwierdź"

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        tv_question.text = question.question
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }

    private fun defaultOptionsView() {
        optionSelected = false
        optionLocked = false

        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT //czcionka
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    //Funkcja opisująca co ma się wydarzyć,
    //po wciśnieciu każdego z przycisków przez użytkownika
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
            R.id.btn_submit -> {
                if (optionSelected) {
                    if (mSelectedOptionPosition == 0) {
                        mCurrentPosition++

                        when {
                            mCurrentPosition <= mQuestionList!!.size -> {
                                setQuestion()
                            }
                            else -> {
                                //Wyświetla powiadomienie w formie dymku
                                Toast.makeText(
                                    this,
                                    "Ukończyłeś quiz!", Toast.LENGTH_SHORT
                                ).show()
                                //Otwiera nową aktywność i przekazuje uzbierane punkty
                                val intent = Intent(this, ResultActivity::class.java)
                                intent.putExtra("points", points)
                                startActivity(intent)
                                finish()
                            }
                        }
                    } else {
                        val question = mQuestionList?.get(mCurrentPosition - 1)
                        if (question!!.correctOption != mSelectedOptionPosition) {
                            answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                        } else {
                            answerView(question.correctOption, R.drawable.correct_option_border_bg)
                            points++;
                        }
                        if (mCurrentPosition == mQuestionList!!.size) {
                            btn_submit.text = "Zakończ"
                        } else {
                            btn_submit.text = "Dalej"
                        }
                        optionLocked = true
                        mSelectedOptionPosition = 0
                    }
                } else {
                    Toast.makeText(
                        this,
                        "Wybierz odpowiedź", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    //Zmienia wygląd opcji wybranej i czyści wygląd niewybranych
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        if (!optionLocked) {
            defaultOptionsView()
            mSelectedOptionPosition = selectedOptionNum
            tv.setTextColor(Color.parseColor("#363A43"))
            tv.setTypeface(tv.typeface, Typeface.BOLD)
            tv.background = ContextCompat.getDrawable(
                this,
                R.drawable.selected_option_border_bg
            )
            optionSelected = true
        }
    }

    //Zamiana wyglądu zaznaczonej odpowiedzi na (zależnie od widoku) poprawną, lub złą
    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }
}