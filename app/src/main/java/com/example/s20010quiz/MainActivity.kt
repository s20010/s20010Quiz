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
    // タイトルの配列と、選択肢の２次配列　（正解、選択肢１、選択肢２，選択肢３の順番）
    private val quizTitle = arrayOf("１問目","２問目","３問目","４問目","５問目","６問目","７問目","８問目","９問目","１０問目")
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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //viewを取得
        val Question1 : TextView = findViewById(R.id.Question1)
        val Btn0 : Button = findViewById(R.id.Btn0)
        val Btn1 : Button = findViewById(R.id.Btn1)
        val Btn2 : Button = findViewById(R.id.Btn2)
        val Btn3 : Button = findViewById(R.id.Btn3)
        val Next : Button = findViewById(R.id.Next)

        //カウント数と、最初の問題を表示
        Question1.text = quizTitle[0]

        //0-3までのリスト用意=>シャッフル
        val list = listOf(0,1,2,3)
        val num = list.shuffled()

        //ボタンにquizDataを表示して、Nextボタンは無効化
        //シャッフルしたnumを表示
        Btn0.text = quizData[0][num[0]]
        Btn1.text = quizData[0][num[1]]
        Btn2.text = quizData[0][num[2]]
        Btn3.text = quizData[0][num[3]]
        Next.isEnabled = false

        //btn0を押したときの正誤判定
        Btn0.setOnClickListener {
            if (Btn0.text == quizData[i][0]) {
                //正解アラートダイアログ
                AlertDialog.Builder(this)
                    .setTitle("正解！")
                    .setMessage(quizData[i][0])
                    .setPositiveButton("OK",null)
                    .show()
                //正解したら回答ボタンを無効化とNEXTボタンを有効化
                Btn0.isEnabled = false
                Btn1.isEnabled = false
                Btn2.isEnabled = false
                Btn3.isEnabled = false
                Next.isEnabled = true
            } else {
                //不正解
                Question1.text = "不正解"
            }
        }



        //TRYボタンのインテント設定
        val TryIntent = findViewById<Button>(R.id.Try)

        //TRYボタンがタップされたとき
        TryIntent.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, QuizActivity::class.java)
                startActivity(intent)
            }
        })
    }
}