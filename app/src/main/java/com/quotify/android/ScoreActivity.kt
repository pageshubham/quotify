package com.quotify.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.quotify.android.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {

    lateinit var binding: ActivityScoreBinding
    lateinit var viewModelFactory: ScoreViewModelFactory
    lateinit var viewModel: ScoreViewModel

    private val edtScore: EditText
        get() = findViewById(R.id.edtScore)

    private val btnUpdate: Button
        get() = findViewById(R.id.btnUpdate)

    private val tvHighScore: TextView
        get() = findViewById(R.id.tvHighScore)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_score)

        viewModelFactory = ScoreViewModelFactory(20)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ScoreViewModel::class.java)

        viewModel.highScore.observe(this, Observer {
            tvHighScore.text = "High Score: $it"
        })

        btnUpdate.setOnClickListener {
            val newScore = edtScore.text.trim().toString().toInt()
            viewModel.updateScore(newScore)
        }
    }

}