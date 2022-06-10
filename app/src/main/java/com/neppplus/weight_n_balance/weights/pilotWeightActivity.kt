package com.neppplus.weight_n_balance.weights

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.neppplus.weight_n_balance.R
import com.neppplus.weight_n_balance.Utils.HideKeyboard
import com.neppplus.weight_n_balance.databinding.ActivityPilotWeightBinding
import kotlinx.android.synthetic.main.activity_pilot_weight.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class pilotWeightActivity : AppCompatActivity() {

    var pilotWeight : Int = 0
    var pilotWeight2 : Int = 0
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
        coPilotWeightInput()
        conFirmBtn()
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
            pilotWeightTxt.text = "${pilotWeight} KG"

        }
        pilotWeightSlider2.addOnChangeListener { slider, value, fromUser ->
            pilotWeight2 = pilotWeightSlider2.value.toInt()

            pilotWeightTxt2.text = "${pilotWeight2} KG"


        }
        // Responds to when slider's value is changed

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun pilotWeightInput() {

        pilotWeightTxt.setOnClickListener {

            pilotWeightTxt.visibility = View.GONE
            weightEdt.visibility = View.VISIBLE
        }

            pilotAddBtn.setOnClickListener {
                HideKeyboard.hideSoftInput(this,weightEdt)
                weight = weightEdt.text.toString()

                if (weightEdt.isVisible) {
                    pilotWeightTxt.text = "${weight} KG"
                    pilotWeightTxt.visibility = View.VISIBLE
                    weightEdt.visibility = View.GONE
                    PilotWeightHere.text = "${weight} KG"
                }
                else
                {
                weight = weightEdt.text.toString()
                pilotWeightTxt.visibility = View.VISIBLE
                weightEdt.visibility = View.GONE
                    PilotWeightHere.text = "${pilotWeight} KG"}
            }
            }
    fun coPilotWeightInput() {
        pilotWeightTxt2.setOnClickListener {
            pilotWeightTxt2.visibility = View.GONE
            weightEdt2.visibility = View.VISIBLE
        }

        coPilotAddBtn.setOnClickListener {
            HideKeyboard.hideSoftInput(this,weightEdt2)
            weight = weightEdt2.text.toString()

            if (weightEdt2.isVisible) {
                pilotWeightTxt2.text = "${weight} KG"
                pilotWeightTxt2.visibility = View.VISIBLE
                weightEdt2.visibility = View.GONE
                coPilotWeightHere.text = "${weight} KG"
            }
            else
            {
                weight = weightEdt2.text.toString()
                pilotWeightTxt2.visibility = View.VISIBLE
                weightEdt2.visibility = View.GONE
                coPilotWeightHere.text = "${pilotWeight2} KG" }
        }
    }
    fun conFirmBtn() {
        conFirmBtn.setOnClickListener {

                val pilotWeight = PilotWeightHere.text.toString()
            val coPilotWeight = coPilotWeightHere.text.toString()

//            inputData 변수설정
                val resultIntent = Intent()
                resultIntent.putExtra("pilotWeight", pilotWeight)
            resultIntent.putExtra("coPilotWeight",coPilotWeight)
                setResult(Activity.RESULT_OK,resultIntent)
            finish()

        }
    }
    }

