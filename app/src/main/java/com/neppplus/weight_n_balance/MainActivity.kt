package com.neppplus.weight_n_balance

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.neppplus.weight_n_balance.weights.pilotWeightActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val REQ_FOR_PILOT = 1002

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myIntent = Intent(this, pilotWeightActivity::class.java)


        weightBtn.setOnClickListener {
            startActivityForResult(myIntent,1002)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val pilotData = data?.getStringExtra("pilotWeight")
        val coPilotData = data?.getStringExtra("coPilotWeight")

        if (resultCode == Activity.RESULT_OK) {
            setPilotWeight.text = pilotData
            setCoPilotWeight.text = coPilotData
                }
            }
        }




