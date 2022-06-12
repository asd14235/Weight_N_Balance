package com.neppplus.weight_n_balance.Alerts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.neppplus.weight_n_balance.R
import kotlinx.android.synthetic.main.activity_fwd_pax_alert.*

class fwdPaxAlert : AppCompatActivity() {


    var pax1 : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fwd_pax_alert)
        setupEvents()
        setValues()

    }

    fun setupEvents(){

    }

    fun setValues() {
        alertFwdPaxEdt()

    }

    fun alertFwdPaxEdt() {
        PAXWeightSlider2.addOnChangeListener { slider, value, fromUser ->
           alertPaxWeightEdt1.setText((value.toInt().toString()))
        }
    }
}






