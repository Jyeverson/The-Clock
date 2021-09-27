
package com.example.theclock.stopwatch

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Window
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.TextView
import androidx.preference.PreferenceManager
import com.example.theclock.R

class StopwatchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_stopwatch)


        titleActionBar()
    }

    private fun titleActionBar() {
        val seekBar = findViewById<SeekBar>(R.id.progressBar)
        seekBar.max = (durationSeekBar()?.times(60000))?.toInt()!!
        val countDownTimer =
            object : CountDownTimer(durationSeekBar()?.times(60000)?.toLong()!!, 1) {
                override fun onTick(millisUntilFinished: Long) {
                        val minute = (millisUntilFinished / 1000) / 60
                        val seconds = (millisUntilFinished / 1000) % 60
                    seekBar.progress =
                            (durationSeekBar()?.times(60000)?.minus(millisUntilFinished))?.toInt()!!

                }

                override fun onFinish() {
                }
            }
        countDownTimer.start()
    }


    fun durationSeekBar(): Double? {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        return sharedPref.getString("st_minutes", "3")?.toDouble()
    }

}