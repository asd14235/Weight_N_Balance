package com.neppplus.weight_n_balance.weights

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
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
        pilotWeightInput()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun currentDateTime() {
        var cDate = LocalDateTime.now()
        var Strnow = cDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        currentDate.text = Strnow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    }

    fun pilotWeightSlider() {
        pilotWeightSlider.addOnChangeListener { slider, value, fromUser ->

            pilotWeightTxt.text = "${value.toInt().toString()} Kg"

        }
        pilotWeightSlider2.addOnChangeListener { slider, value, fromUser ->
            pilotWeightTxt2.text = "${value.toInt().toString()} Kg"
        }
        // Responds to when slider's value is changed
    }

    fun pilotWeightInput() {
        pilotAddBtn.setOnClickListener {
            var pilotWeight = pilotWeightSlider.value

            pilotWeightTxt.text = (pilotWeight + 10).toInt().toString()
        }
        pilotWeightTxt.setOnClickListener {

        }
    }
}