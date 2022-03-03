package com.jc.lottosimulator_20220303

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setValues()
        setupEvents()

    }

    private fun setValues() {


    }

    private fun setupEvents() {

        btnBuyLotto.setOnClickListener {
            // 6개의 당첨 번호 생성
            // 코틀린의 for 문은 for-each 문법 기반.
            for(i in 1..5) {
                Log.d("반복문 확인", "setupEvents: $i")
            }

            // 만들어진 당첨 번호 6개 -> TextView 에 표현

            // 보너스 번호 생성

            // 생성된 보너스 번호 TextView 에 배치

        }
    }

    private fun buyLotto() {

    }

}