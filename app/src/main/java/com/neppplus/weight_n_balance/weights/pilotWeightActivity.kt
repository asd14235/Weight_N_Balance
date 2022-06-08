package com.neppplus.weight_n_balance.weights

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.neppplus.weight_n_balance.R
import com.neppplus.weight_n_balance.databinding.ActivityPilotWeightBinding
import kotlinx.android.synthetic.main.activity_pilot_weight.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class pilotWeightActivity : AppCompatActivity() {

    var pilotWeight : Int = 0
    var weight : String = ""
    lateinit var binding : ActivityPilotWeightBinding

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
            pilotWeight = pilotWeightSlider.value.toInt()
            pilotWeightTxt.text = "${pilotWeight} Kg"

        }
        pilotWeightSlider2.addOnChangeListener { slider, value, fromUser ->
            pilotWeightTxt2.text = "${value.toInt().toString()} Kg"
        }
        // Responds to when slider's value is changed

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun pilotWeightInput() {

        binding.pilotWeightTxt.setOnClickListener {
            binding.pilotWeightTxt.visibility = View.GONE
            binding.weightEdt.visibility = View.VISIBLE
        }

            binding.pilotAddBtn.setOnClickListener {
                weight = weightEdt.text.toString()

                if (weightEdt.isVisible) {
                    pilotWeightTxt.text = "${weight} Kg"
                    pilotWeightTxt.visibility = View.VISIBLE
                    weightEdt.visibility = View.GONE
                }
                else
                {
                weight = weightEdt.text.toString()
                pilotWeightTxt.visibility = View.VISIBLE
                weightEdt.visibility = View.GONE }
            }
            }
    }

