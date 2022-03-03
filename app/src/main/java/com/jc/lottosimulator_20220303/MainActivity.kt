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
            for (i in 0 until 6) {
                // 괜찮은 번호가 나올 때 까지 무한 반복
                while (true) {
                    // 1 ~ 45의 랜덤 숫자, Math.random() 은 0 ~ 1 => 1 ~ 45.xxx 로 가공 -> int 로 캐스팅
                    val randomNum = ((Math.random() * 45) + 1).toInt()
                    // 중복 감사 통과 시 while break
                    if (true) {
                        break
                    }

                }
            }

            // 만들어진 당첨 번호 6개 -> TextView 에 표현

            // 보너스 번호 생성

            // 생성된 보너스 번호 TextView 에 배치

        }
    }

    private fun buyLotto() {

    }

}