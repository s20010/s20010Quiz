package com.example.s20010quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.s20010quiz.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Try.setOnClickListener { onChange(it) }
        }
    fun onChange (view: View?) {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)

        }
    }


/*
class MainActivity : AppCompatActivity() {
    // タイトルの配列と、選択肢の２次配列　（正解、選択肢１、選択肢２，選択肢３の順番）
    private val quizTitle = arrayOf("１問目","２問目","３問目","４問目")
    private val quizData = arrayOf(
        arrayOf("A0","A1","A2","A3"),
        arrayOf("B0","B1","B2","B3"),
        arrayOf("C0","C1","C2","C3"),
        arrayOf("D0","D1","D2","D3")
    )
    //カウントの変数
    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewを取得
        val question1 : TextView = findViewById(R.id.Question1)
        val btn0 : Button = findViewById(R.id.Btn0)
        val btn1 : Button = findViewById(R.id.Btn1)
        val btn2 : Button = findViewById(R.id.Btn2)
        val btn3 : Button = findViewById(R.id.Btn3)
        val next : Button = findViewById(R.id.Next)

        //カウント数と、最初の問題を表示
        question1.text = quizTitle[0]

        //0-3までのリスト用意=>シャッフル
        val list = listOf(0,1,2,3)
        val num = list.shuffled()

        //ボタンにquizDataを表示して、Nextボタンは無効化
        //シャッフルしたnumを表示

        btn0.text = quizData[0][num[0]]
        btn1.text = quizData[0][num[1]]
        btn2.text = quizData[0][num[2]]
        btn3.text = quizData[0][num[3]]
        next.isEnabled = false



        //btn0を押したときの正誤判定
        btn0.setOnClickListener {
            if (btn0.text == quizData[i][0]) {
                //正解アラートダイアログ
                AlertDialog.Builder(this)
                    .setTitle("正解！")
                    .setMessage(quizData[i][0])
                    .setPositiveButton("OK",null)
                    .show()
                //正解したら回答ボタンを無効化とNEXTボタンを有効化
                btn0.isEnabled = false
                btn1.isEnabled = false
                btn2.isEnabled = false
                btn3.isEnabled = false
                next.isEnabled = true
            } else {
                //不正解
                question1.text = "不正解"
            }
        }
    }
}

 */