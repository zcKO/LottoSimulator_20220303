package com.jc.lottosimulator_20220303

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // 내 번호 6개
    // 코틀린은 단순 배열 초기화 int[] arr = { }; 은 지원하지 않는다.
    // 숫자 목록을 파라미터로 넣으면, array 로 만들어주는 함수 실행
    val mMyNumbers = arrayOf(13, 17, 23, 27, 36, 41)

    // 컴퓨터가 뽑은 당첨 번호 6개를 저장할 ArrayList
    val mWinNumberList = ArrayList<Int>()

    // 당첨 번호를 보여줄 6개의 TextView 를 담아둘 ArrayList
    val mWinNumberTextViewList = ArrayList<TextView>()

    // 화면이 어디인지 줄 필요가 없기 때문에 lateinit 대신 var 로 만듦.
    var mBonusNum = 0     // 보너스 번호는 매 판마다 새로 뽑아야 가능하다. 변경 소지가 있다.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setValues()
        setupEvents()

    }

    private fun setValues() {
        mWinNumberTextViewList.add(txtWinNum01)
        mWinNumberTextViewList.add(txtWinNum02)
        mWinNumberTextViewList.add(txtWinNum03)
        mWinNumberTextViewList.add(txtWinNum04)
        mWinNumberTextViewList.add(txtWinNum05)
        mWinNumberTextViewList.add(txtWinNum06)
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

//            for (winNum in mWinNumberList) {}
            // for > 순회하면서, 당첨 번호 / 몇 번째 순회인지 필요 -> TextView 를 찾아야 한다.
            mWinNumberList.forEachIndexed { index, winNum ->

                // 순서에 맞는 TextView 추출 -> 문구로 당첨번호 설정
                mWinNumberTextViewList[index].text = winNum.toString()

            }

            // 보너스 번호 생성 -> 1 ~ 45 중 하나, 당첨 번호와 겹치치 않게
            while (true) {
                val randomNum = ((Math.random() * 45) + 1).toInt()

                if (mWinNumberList.contains(randomNum).not()) {
                    // 겹치치 않는 숫자 활용
                    mBonusNum = randomNum
                    break
                }
            }

            // 생성된 보너스 번호 TextView 에 배치
            txtBonusNum.text = mBonusNum.toString()

            // 내 숫자 6개와 비교, 등수 판정
            checkLottoRank()
        }
    }

    private fun checkLottoRank() {
        // 내 벊소 목록 / 당첨 번호 목록 중, 같은 숫자가 몇개인치 체크
        var correctCount = 0

        // 내 번호를 하니씩 조회
        for (myNum in mMyNumbers) {
            // 당첨 번호를 맞추었는지 확인 -> 당첨번호 목록에 내 번호가 들어있는지 확인
            if (mWinNumberList.contains(myNum)) {
                correctCount++
            }
        }

        // 맞춘 갯 수에 따른 등수 판정
        when (correctCount) {

            6 -> {
                Toast.makeText(this, "1등 입니다.", Toast.LENGTH_SHORT).show()
            }
            5 -> {
                // 보너스 번호를 맞췄는지 => 보너스 번호가 내 번호 목록에 들어있는지 확인
                if (mMyNumbers.contains(mBonusNum)) {
                    Toast.makeText(this, "2등 입니다.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "3등 입니다.", Toast.LENGTH_SHORT).show()
                }
            }
            4 -> {
                Toast.makeText(this, "4등 입니다.", Toast.LENGTH_SHORT).show()
            }
            3 -> {
                Toast.makeText(this, "5등 입니다.", Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(this, "낙첨 입니다.", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun buyLotto() {

    }

}