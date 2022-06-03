package com.neppplus.weight_n_balance

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.neppplus.weight_n_balance.weights.pilotWeightActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    fun setupEvents() {

        weightBtn.setOnClickListener {
            val myIntent = Intent(this, pilotWeightActivity::class.java)
            startActivity(myIntent)
        }



    }

    fun setValues() {
    }
    }

