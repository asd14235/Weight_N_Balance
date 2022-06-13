package com.neppplus.weight_n_balance.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.neppplus.weight_n_balance.customAlert.OverViewActivity
import com.neppplus.weight_n_balance.databinding.FragmentWeightBinding
import com.neppplus.weight_n_balance.dialog.AftPaxAlertDialog
import com.neppplus.weight_n_balance.dialog.CustomAlertDialog
import com.neppplus.weight_n_balance.dialog.PilotWeightAlertDialog
import com.neppplus.weight_n_balance.weightData.WeightData
import com.neppplus.weight_n_balance.weights.pilotWeightActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_weight.*

class WeightFragment : Fragment() {

    lateinit var binding : FragmentWeightBinding

    lateinit var mWeightData : WeightData

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeightBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myIntent = Intent(requireContext(), pilotWeightActivity::class.java)
        val myIntent2 = Intent(requireContext(), OverViewActivity::class.java)

        weightBtn.setOnClickListener {
            startActivityForResult(myIntent, 1002)
        }

        testBtn.setOnClickListener {
            startActivity(myIntent2)
        }

        binding.fwdPaxLayout.setOnClickListener {

            val alert = CustomAlertDialog(requireContext())
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
            val pilotAlert = PilotWeightAlertDialog(requireContext())
            pilotAlert.myDialog()
            pilotAlert.binding.pilotWeightEdtBtn.setOnClickListener {
                setPilotWeight.text = "${pilotAlert.binding.weightEdt.text} KG"
                setCoPilotWeight.text = "${pilotAlert.binding.weightEdt2.text} KG"
                pilotAlert.dialog.dismiss()
            }
        }
        binding.aftLayout.setOnClickListener {
            val Aftalert = AftPaxAlertDialog(requireContext())
            Aftalert.myDialog()

            Aftalert.binding.conFirmBtn.setOnClickListener {
                Toast.makeText(requireContext(), "변경 완료", Toast.LENGTH_SHORT).show()
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