package com.neppplus.weight_n_balance

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.neppplus.weight_n_balance.databinding.ActivityMainBinding
import com.neppplus.weight_n_balance.weights.pilotWeightActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myIntent = Intent(this, pilotWeightActivity::class.java)

        weightBtn.setOnClickListener {
            startActivityForResult(myIntent, 1002)
        }

        binding.fwdPaxLayout.setOnClickListener {

            val fwdAlert = LayoutInflater.from(this).inflate(R.layout.activity_fwd_pax_alert,null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(fwdAlert)
            val dialog = mBuilder.create()
            dialog.window?.decorView?.setBackgroundResource(R.drawable.dialog_background)
            dialog.show()

        }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val pilotData = data?.getStringExtra("pilotWeight")
        val coPilotData = data?.getStringExtra("coPilotWeight")
        val pax1 = data?.getStringExtra("pax1")
        val pax2 = data?.getStringExtra("pax2")
        val pax3 = data?.getStringExtra("pax3")
        val apax1 = data?.getStringExtra("apax1")
        val apax2 = data?.getStringExtra("apax2")
        val apax3 = data?.getStringExtra("apax3")

        if (resultCode == Activity.RESULT_OK) {
            setPilotWeight.text = "${pilotData} KG"
            setCoPilotWeight.text = "${coPilotData} KG"

            setPaxTxt1.text = "${pax1} KG"
            setPaxTxt2.text = "${pax2} KG"
            setPaxTxt3.text = "${pax3} KG"

            setAPaxTxt1.text = "${apax1} KG"
            setAPaxTxt2.text = "${apax2} KG"
            setAPaxTxt3.text = "${apax3} KG"

            if (apax2.isNullOrBlank()) {
                AftPax1.visibility = View.GONE
                AftPax2.visibility = View.GONE
            } else {

                if (apax3.isNullOrBlank()) {
                    AftPax1.visibility = View.VISIBLE
                    AftPax2.visibility = View.GONE
                } else {
                    AftPax1.visibility = View.VISIBLE
                    AftPax2.visibility = View.VISIBLE
                }
            }

            if (pax2.isNullOrBlank()) {
                fwdPaxLayer2.visibility = View.GONE
                fwdPaxLayer3.visibility = View.GONE
            } else {
                if (pax3.isNullOrBlank()) {
                    fwdPaxLayer2.visibility = View.VISIBLE
                    fwdPaxLayer3.visibility = View.GONE
                } else {
                    fwdPaxLayer2.visibility = View.VISIBLE
                    fwdPaxLayer3.visibility = View.VISIBLE
                }
            }
        }
    }

}




