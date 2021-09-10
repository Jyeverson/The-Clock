package com.example.theclock

import android.content.pm.ActivityInfo
import android.opengl.ETC1.getWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.TypedValue
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ClockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clock)

        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE
        timer()
    }

    fun timer(){
        val textTiming = findViewById<TextView>(R.id.txt_clock)
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()
        val updateTimer = String.format("%02d:%02d", calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE))

        val countDownTimer = object : CountDownTimer(60000, 1){
            override fun onTick(millisUntilFinished: Long) {
                textTiming.setText(updateTimer)
            }
            override fun onFinish() {
            }
        }
        countDownTimer.start()

    }

}