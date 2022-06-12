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
import kotlinx.android.synthetic.main.activity_pilot_weight.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class pilotWeightActivity : AppCompatActivity() {

    var pilotWeight: Int = 0
    var pilotWeight2: Int = 0
    var pax1 : Int = 0
    var pax2 : Int = 0
    var pax3 : Int = 0
    var aPax1 : Int = 0
    var aPax2 : Int = 0
    var aPax3 : Int = 0



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
        conFirmBtn()
        FwdPaxAdd()
        FwdPaxWeight()
        AftPaxAdd()
        AftPaxWeight()
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
//            pilotWeightTxt.text = "${pilotWeight} KG"
            weightEdt.setText(value.toInt().toString())

        }
        pilotWeightSlider2.addOnChangeListener { slider, value, fromUser ->
            pilotWeight2 = pilotWeightSlider2.value.toInt()
            weightEdt2.setText(value.toInt().toString())

        }
        // Responds to when slider's value is changed

    }

    @RequiresApi(Build.VERSION_CODES.O)

    fun conFirmBtn() {
        conFirmBtn.setOnClickListener {
            val pilotWeight = weightEdt.text.toString()
            val coPilotWeight = weightEdt2.text.toString()
            val pax1Weight = PaxWeightEdt1.text.toString()
            val pax2Weight = PaxWeightEdt2.text.toString()
            val pax3Weight = PaxWeightEdt3.text.toString()
            val apax1Weight = AftPaxWeightEdt1.text.toString()
            val apax2Weight = AftPaxWeightEdt2.text.toString()
            val apax3Weight = AftPaxWeightEdt3.text.toString()

//            inputData 변수설정
            val resultIntent = Intent()
            resultIntent.putExtra("pilotWeight", pilotWeight)
            resultIntent.putExtra("coPilotWeight", coPilotWeight)
            resultIntent.putExtra("pax1",pax1Weight)
            resultIntent.putExtra("pax2",pax2Weight)
            resultIntent.putExtra("pax3",pax3Weight)
            resultIntent.putExtra("apax1",apax1Weight)
            resultIntent.putExtra("apax2",apax2Weight)
            resultIntent.putExtra("apax3",apax3Weight)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()

        }
    }

    fun FwdPaxAdd() {
        addFPaxBtn.setOnClickListener {
            if (!fpax2Layer.isVisible)
                fpax2Layer.visibility = View.VISIBLE
            addFPaxBtn.visibility = View.GONE
            addFPaxBtn2.visibility = View.VISIBLE
            PAXWeightSlider2.visibility = View.VISIBLE
        }
        addFPaxBtn2.setOnClickListener {
            fPax3Layer.visibility = View.VISIBLE
            addFPaxBtn2.visibility = View.GONE
            addFPaxBtn3.visibility = View.VISIBLE
            PAXWeightSlider3.visibility = View.VISIBLE
        }
        addFPaxBtn3.setOnClickListener {
            fPax4Layer.visibility = View.VISIBLE
            addFPaxBtn3.visibility = View.GONE
            addFPaxBtn4.visibility = View.VISIBLE

        }

    }

    fun FwdPaxWeight() {
        PAXWeightSlider.addOnChangeListener { slider, value, fromUser ->
            pax1 = PAXWeightSlider.value.toInt()
            PaxWeightEdt1.setText((value.toInt().toString()))
        }
        PAXWeightSlider2.addOnChangeListener { slider, value, fromUser ->
            pax2 = PAXWeightSlider.value.toInt()
            PaxWeightEdt2.setText((value.toInt().toString()))
        }
        PAXWeightSlider3.addOnChangeListener { slider, value, fromUser ->
            pax3 = PAXWeightSlider.value.toInt()
            PaxWeightEdt3.setText((value.toInt().toString()))
        }

    }

    fun AftPaxAdd() {
        AftPaxAddBtn1.setOnClickListener {
            AftPaxLayer2.visibility = View.VISIBLE
            AftPaxAddBtn1.visibility = View.GONE
            AftPaxAddBtn2.visibility = View.VISIBLE
            AftPAXWeightSlider2.visibility = View.VISIBLE
        }
        AftPaxAddBtn2.setOnClickListener {
            AftPaxAddBtn2.visibility = View.GONE
            AftPaxAddBtn3.visibility = View.VISIBLE
            AftPaxLayer3.visibility = View.VISIBLE
            AftPAXWeightSlider3.visibility = View.VISIBLE
        }

    }

    fun AftPaxWeight() {
        AftPAXWeightSlider1.addOnChangeListener { slider, value, fromUser ->
            aPax1 = AftPAXWeightSlider1.value.toInt()
            AftPaxWeightEdt1.setText((value.toInt().toString()))
        }
        AftPAXWeightSlider2.addOnChangeListener { slider, value, fromUser ->
            aPax2 = AftPAXWeightSlider2.value.toInt()
            AftPaxWeightEdt2.setText((value.toInt().toString()))
        }
        AftPAXWeightSlider3.addOnChangeListener { slider, value, fromUser ->
            aPax3 = AftPAXWeightSlider3.value.toInt()
            AftPaxWeightEdt3.setText((value.toInt().toString()))
        }
    }
    }


