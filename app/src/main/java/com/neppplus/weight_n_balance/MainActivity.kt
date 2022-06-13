package com.neppplus.weight_n_balance

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.neppplus.weight_n_balance.databinding.ActivityFwdPaxAlertBinding
import com.neppplus.weight_n_balance.databinding.ActivityMainBinding
import com.neppplus.weight_n_balance.databinding.ActivityPilotWeightBinding
import com.neppplus.weight_n_balance.databinding.AftPaxWeightAlertBinding
import com.neppplus.weight_n_balance.dialog.AftPaxAlertDialog
import com.neppplus.weight_n_balance.dialog.CustomAlertDialog
import com.neppplus.weight_n_balance.dialog.PilotWeightAlertDialog
import com.neppplus.weight_n_balance.weightData.WeightData
import com.neppplus.weight_n_balance.weights.pilotWeightActivity
import kotlinx.android.synthetic.main.activity_fwd_pax_alert.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mWeightData : WeightData


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myIntent = Intent(this, pilotWeightActivity::class.java)

        weightBtn.setOnClickListener {
            startActivityForResult(myIntent, 1002)
        }

        binding.fwdPaxLayout.setOnClickListener {

            val alert = CustomAlertDialog(this)
            alert.binding.titleTxt.text = "PAX 1"
            alert.myDialog()

            alert.binding.confirmBtn.setOnClickListener {
                setPaxTxt1.text = "${alert.binding.alertPaxWeightEdt1.text} KG"
                setPaxTxt2.text = "${alert.binding.PaxWeightEdt2.text} KG"
                fwdPaxLayer2.visibility = View.VISIBLE
                Log.d("asd",alert.binding.PaxWeightEdt2.toString())
                setPaxTxt3.text = "${alert.binding.PaxWeightEdt3.text} KG"
                fwdPaxLayer3.visibility = View.VISIBLE
                alert.dialog.dismiss()
            }
        }
        binding.pilotWeightLayer.setOnClickListener {
            val pilotAlert = PilotWeightAlertDialog(this)
            pilotAlert.myDialog()
            pilotAlert.binding.pilotWeightEdtBtn.setOnClickListener {
                setPilotWeight.text = "${pilotAlert.binding.weightEdt.text} KG"
                setCoPilotWeight.text = "${pilotAlert.binding.weightEdt2.text} KG"
                pilotAlert.dialog.dismiss()
            }
        }
        binding.aftLayout.setOnClickListener {
            val Aftalert = AftPaxAlertDialog(this)
            Aftalert.myDialog()

            Aftalert.binding.conFirmBtn.setOnClickListener {
                Toast.makeText(this, "변경 완료", Toast.LENGTH_SHORT).show()
                setAPaxTxt1.text = "${Aftalert.binding.AftPaxWeightEdt1.text} KG"
                setAPaxTxt2.text = "${Aftalert.binding.AftPaxWeightEdt2.text} KG"
                AftPax1.visibility = View.VISIBLE
                setAPaxTxt3.text = "${Aftalert.binding.AftPaxWeightEdt3.text} KG"
                AftPax2.visibility = View.VISIBLE
                Aftalert.dialog.dismiss()
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        val pilotData = data?.getStringExtra("pilotWeight")
//        val coPilotData = data?.getStringExtra("coPilotWeight")
//        val pax1 = data?.getStringExtra("pax1")
//        val pax2 = data?.getStringExtra("pax2")
//        val pax3 = data?.getStringExtra("pax3")
//        val apax1 = data?.getStringExtra("apax1")
//        val apax2 = data?.getStringExtra("apax2")
//        val apax3 = data?.getStringExtra("apax3")
        if (resultCode == Activity.RESULT_OK) {
            mWeightData = data?.getSerializableExtra("weightData") as WeightData

            setPilotWeight.text = "${mWeightData.pilotWeight} KG"
            setCoPilotWeight.text = "${mWeightData.coPilotWeight} KG"

            setPaxTxt1.text = "${mWeightData.pax1} KG"
            setPaxTxt2.text = "${mWeightData.pax2} KG"
            setPaxTxt3.text = "${mWeightData.pax3} KG"

            setAPaxTxt1.text = "${mWeightData.apax1} KG"
            setAPaxTxt2.text = "${mWeightData.apax2} KG"
            setAPaxTxt3.text = "${mWeightData.apax3} KG"

            if (mWeightData.apax2.isNullOrBlank()) {
                AftPax1.visibility = View.GONE
                AftPax2.visibility = View.GONE
            } else {

                if (mWeightData.apax3.isNullOrBlank()) {
                    AftPax1.visibility = View.VISIBLE
                    AftPax2.visibility = View.GONE
                } else {
                    AftPax1.visibility = View.VISIBLE
                    AftPax2.visibility = View.VISIBLE
                }
            }

            if (mWeightData.pax2.isNullOrBlank()) {
                fwdPaxLayer2.visibility = View.GONE
                fwdPaxLayer3.visibility = View.GONE
            } else {
                if (mWeightData.pax3.isNullOrBlank()) {
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




