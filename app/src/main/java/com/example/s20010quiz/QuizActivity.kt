package com.example.s20010quiz

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.s20010quiz.databinding.ActivityQuizBinding
import android.os.CountDownTimer
import android.view.View
import kotlin.system.measureTimeMillis

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val start = System.currentTimeMillis();


        //自身のインテントを受け取る
        var index = intent.getIntExtra("INDEX", 1)
        var score = intent.getIntExtra("SCORE", 0)
        var time = intent.getLongExtra("TIME",0)

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


        //４択をランダムに表示するためのリストをつくる
        val list = listOf(2, 3, 4, 5)
        val num = list.shuffled()

        //今の問題に対応するリストを２次元リストから変数に代入
        var q = parent_list[index]

        //答えを保持
        val answer = q[2]
        //ビューに値を代入
        binding.SubTitle.text = "第 ${index.toString()} 問"
        binding.Question1.text = q[0]
        binding.select1.text = q[num[0]]
        binding.select2.text = q[num[1]]
        binding.select3.text = q[num[2]]
        binding.select4.text = q[num[3]]

        //タイマーのインスタンス生成
        val timer = object : CountDownTimer(
            10000,
            1000
        ) {
            override fun onTick(millisUntilFinished: Long) {
                val second = millisUntilFinished / 1000L % 60L
                binding.Timer.text = second.toString()
            }
            //終了したら、NEXTボタンをクリック
            override fun onFinish() {
                binding.Next.performClick()
            }
        }.start()
        //10問目まで繰り返す
        index++

        val times = measureTimeMillis {
            timer.start()
        }
        println(times)

        binding.Next.setOnClickListener {

        //選ばれているボタンのテキストを取得
        val id = binding.Selecters.checkedRadioButtonId
        val radioButton = findViewById<RadioButton>(id)
        val selectText = radioButton.text

        //正解の場合、
        if(selectText == answer) {
            binding.Question1.text = "正解"
            score++
        }

        //不正解の場合
        else
            binding.Question1.text = "不正解"


    }
        //次の画面へ遷移
        binding.Next.setOnClickListener {
            //10を超えた場合は最終結果へ
            if (index > 10) {
                timer.cancel()
                val end = System.currentTimeMillis()
                //時間の計算
                time += (end - start) / 1000
                resultChange(it,score, time)
            }
            //10以下の場合は次の問題へ
            else {
                timer.cancel()
                val end = System.currentTimeMillis()
                //時間の計算
                time += (end - start) / 1000
                onChange(it, index, score, time)
            }
        }

    }
    //indexが１０以下の処理
    fun onChange (view: View?, index:Int, score: Int, time: Long) {
        val intent = Intent(this, QuizActivity::class.java)
        intent.putExtra("INDEX", index)
        intent.putExtra("SCORE", score)
        intent.putExtra("TIME",time)
        startActivity(intent)
    }
    //indexが１０を超えた時最終画面へ遷移
    fun resultChange (view: View?, score: Int, time: Long) {

        val intent = Intent(this, Result::class.java)
        intent.putExtra("RESULT_SCORE", score.toString())
        intent.putExtra("RESULT_TIME", time.toString())
        startActivity(intent)
    }


}




