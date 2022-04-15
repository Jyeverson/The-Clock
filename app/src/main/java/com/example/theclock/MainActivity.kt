package com.example.theclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import com.example.theclock.clock.ClockActivity
import com.example.theclock.settings.SettingsActivity
import com.example.theclock.timer.TimerActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.theClock).setOnClickListener {
            val intent = Intent(this, ClockActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.timer).setOnClickListener {
            val intent = Intent(this, TimerActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.settings).setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

    }

}