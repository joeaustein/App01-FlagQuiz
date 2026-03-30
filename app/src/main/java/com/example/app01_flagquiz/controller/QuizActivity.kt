package com.example.app01_flagquiz.controller

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app01_flagquiz.R
import com.example.app01_flagquiz.model.Flag
import com.example.app01_flagquiz.util.Constants
import java.text.Normalizer
import java.util.Locale

class QuizActivity : AppCompatActivity() {

    private lateinit var questions: List<Flag>
    private var index = 0
    private var score = 0
    private lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainQuiz)) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        name = intent.getStringExtra(Constants.USER_NAME) ?: ""

        questions = Constants.getFlags().shuffled().take(5)

        showQuestion()

        findViewById<Button>(R.id.btnSubmit).setOnClickListener {
            checkAnswer()
        }

        findViewById<Button>(R.id.btnNext).setOnClickListener {
            index++
            if (index < 5) {
                showQuestion()
            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(Constants.SCORE, score)
                intent.putExtra(Constants.USER_NAME, name)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun showQuestion() {
        val flag = questions[index]

        findViewById<TextView>(R.id.tvCounter).text = "${index + 1} de 5"
        findViewById<ImageView>(R.id.imgFlag).setImageResource(flag.image)

        findViewById<EditText>(R.id.etAnswer).setText("")
        findViewById<TextView>(R.id.tvResult).text = ""

        findViewById<Button>(R.id.btnSubmit).visibility = View.VISIBLE
        findViewById<Button>(R.id.btnNext).visibility = View.GONE
    }

    private fun checkAnswer() {
        val etAnswer = findViewById<EditText>(R.id.etAnswer)
        val answer = etAnswer.text.toString().trim()
        val correct = questions[index].name

        val tvResult = findViewById<TextView>(R.id.tvResult)

        if (normalizeString(answer).equals(normalizeString(correct), ignoreCase = true)) {
            tvResult.text = "Correto!"
            tvResult.setTextColor(Color.GREEN)
            score += 20
        } else {
            tvResult.text = "Incorreto! Era $correct"
            tvResult.setTextColor(Color.RED)
        }

        findViewById<Button>(R.id.btnSubmit).visibility = View.GONE
        findViewById<Button>(R.id.btnNext).visibility = View.VISIBLE
    }

    private fun normalizeString(input: String): String {
        val normalized = Normalizer.normalize(input, Normalizer.Form.NFD)
        return normalized.replace(Regex("[\\p{InCombiningDiacriticalMarks}]"), "")
    }
}
