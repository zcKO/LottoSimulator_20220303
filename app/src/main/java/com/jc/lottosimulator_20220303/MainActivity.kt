package com.jc.lottosimulator_20220303

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // 컴퓨터가 뽑은 당첨 번호 6개를 저장할 ArrayList
    val mWinNumberList = ArrayList<Int>()

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
            // ArrayList 는 목록을 계속 누적이 가능하므로, 당첨번호 뽑기전에 기존의 당첨번호 전부 삭제 후 다시 랜덤 숫자 생성
            mWinNumberList.clear()
            for (i in 0 until 6) {
                // 괜찮은 번호가 나올 때 까지 무한 반복
                while (true) {
                    // 1 ~ 45의 랜덤 숫자, Math.random() 은 0 ~ 1 => 1 ~ 45.xxx 로 가공 -> int 로 캐스팅
                    val randomNum = ((Math.random() * 45) + 1).toInt()
                    // 중복 감사 통과 시 while break, contains : ~ 포함이 되었는가
                    if (mWinNumberList.contains(randomNum).not()) {
                        // 당첨 번호로, 뽑은 랜덤 숫자 등록
                        mWinNumberList.add(randomNum)
                        break
                    }
                }
            }

            // 만들어진 당첨 번호 6개 -> 작은 수 ~ 큰 수 정렬 -> TextView 에 표현
            mWinNumberList.sort()   // 자바로 직접 작성하던 로직을 객체지향의 특성, 만들어져있는 기능 활용으로 대체
            Log.d("당첨 번호 목록", mWinNumberList.toString())

            for (winNum in mWinNumberList) {

            }

            // 보너스 번호 생성

            // 생성된 보너스 번호 TextView 에 배치

        }
    }

    private fun buyLotto() {

    }

}