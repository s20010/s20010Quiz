package com.example.s20010quiz

import android.app.AlertDialog
import android.app.AppComponentFactory
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.s20010quiz.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding

    private lateinit var parent_list: ArrayList<List<String>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)

        setContentView(binding.root)


        //自身のインテントを受け取る
        var index = intent.getIntExtra("INDEX", 1)
        var score = intent.getIntExtra("SCORE", 0)

        //タイマーを作る

        //CSVを格納
        val assetManager = applicationContext.assets.open("s20010_quiz.csv").bufferedReader()
        var a = assetManager.use() {
            it.readText()
        }
        var b = a.split(",")
        println(b[0])
        val eito = "eito"
        println(eito)
        val a1 = b.take(6)
        b = b.drop(6)
        println(b)
        val a2 = b.take(6)
        b = b.drop(6)
        val a3 = b.take(6)
        b = b.drop(6)
        val a4 = b.take(6)
        b = b.drop(6)
        val a5 = b.take(6)
        b = b.drop(6)
        val a6 = b.take(6)
        b = b.drop(6)
        val a7 = b.take(6)
        b = b.drop(6)
        val a8 = b.take(6)
        b = b.drop(6)
        val a9 = b.take(6)
        b = b.drop(6)
        val a10 = b.take(6)
        b = b.drop(6)
        val a11 = b.take(6)
        b = b.drop(6)


        //２次元リストをつくる
        val parent_list = arrayListOf(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)

        binding.Question1.text = parent_list[1][0]


        //４択をランダムに表示するためのリストをつくる
        val list = listOf(2, 3, 4, 5)
        val num = list.shuffled()

        //今の問題に対応するリストを２次元リストから変数に代入
        var q = parent_list[index]

        //答えを保持
        val answer = q[2]

        binding.SubTitle.text = "第 ${index.toString()} 問"
        binding.Question1.text = q[0]
        binding.select1.text = q[num[0]]
        binding.select2.text = q[num[1]]
        binding.select3.text = q[num[2]]
        binding.select4.text = q[num[3]]

        index++

        val id = binding.Selecters.checkedRadioButtonId
        var takeanswer = findViewById<RadioButton>(id)
        val decision = takeanswer.text

        if (decision == answer) {
            binding.Question1.text = "正解"
            score++
        } else {
            binding.Question1.text = "不正解"
        }

    }
}




