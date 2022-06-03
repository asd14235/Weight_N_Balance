package com.neppplus.weight_n_balance.weights

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.neppplus.weight_n_balance.R
import kotlinx.android.synthetic.main.activity_pilot_weight.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class pilotWeightActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilot_weight)
        setupEvents()
        setValues()
    }

    fun setupEvents() {

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setValues() {
        currentDateTime()
        pilotWeightSlider()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun currentDateTime() {
        var cDate = LocalDateTime.now()
        var Strnow = cDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        currentDate.text = Strnow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    }
    fun pilotWeightSlider() {

        pilotWeightSlider.addOnChangeListener { slider, value, fromUser ->
            pilotWeightTxt.text = value.toInt().toString()

        }
        pilotWeightSlider2.addOnChangeListener { slider, value, fromUser ->
            pilotWeightTxt2.text = value.toInt().toString()
        }
        // Responds to when slider's value is changed
    }
}