package com.example.s20010quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.s20010quiz.databinding.ActivityResultBinding
import android.content.Intent
import android.view.View
import com.example.s20010quiz.databinding.ActivityQuizBinding
import java.util.zip.Inflater

class Result : AppCompatActivity() {
    private lateinit var binding : ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //最終結果を受け取る処理
        val resultScore = intent.getStringExtra("RESULT_SCORE")
        val resultTime = intent.getStringExtra("RESULT_TIME")

        //正解数を表示
        binding.resultScore.text = resultScore
        binding.resultTime.text = resultTime
    }
}