package com.example.theclock

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*


class ClockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clock)

        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE

        val t: Thread = object : Thread() {
            override fun run() {
                try {
                    while (!isInterrupted) {
                        sleep(1000)
                        runOnUiThread {
                            val textTiming = findViewById<TextView>(R.id.txt_clock)
                            val calendar = Calendar.getInstance()
                            calendar.timeInMillis = System.currentTimeMillis()
                            val updateTimer = String.format("%02d:%02d", calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE))
                            textTiming.setText(updateTimer)
                        }
                    }
                } catch (e: InterruptedException) {
                }
            }
        }
        t.start()

    }
}