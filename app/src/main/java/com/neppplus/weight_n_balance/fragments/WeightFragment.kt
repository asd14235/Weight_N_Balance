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
import com.neppplus.weight_n_balance.MainActivity
import com.neppplus.weight_n_balance.Utils.AppUtil
import com.neppplus.weight_n_balance.customAlert.OverViewActivity
import com.neppplus.weight_n_balance.databinding.FragmentWeightBinding
import com.neppplus.weight_n_balance.dialog.AftPaxAlertDialog
import com.neppplus.weight_n_balance.dialog.CustomAlertDialog
import com.neppplus.weight_n_balance.dialog.FuelWeightAlertDialog
import com.neppplus.weight_n_balance.dialog.PilotWeightAlertDialog
import com.neppplus.weight_n_balance.weightData.WeightData
import com.neppplus.weight_n_balance.weights.pilotWeightActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_over_view.*
import kotlinx.android.synthetic.main.fragment_weight.*
import java.text.DecimalFormat

class WeightFragment : Fragment() {

    lateinit var binding: FragmentWeightBinding

    lateinit var mWeightData: WeightData

    val dec = DecimalFormat("#,###.00")


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


        weightBtn.setOnClickListener {
            startActivityForResult(myIntent, 1002)
        }

        binding.fwdPaxLayout.setOnClickListener {

            val alert = CustomAlertDialog(requireContext())
            alert.binding.titleTxt.text = "PAX 1"
            alert.myDialog()

            alert.binding.alertPaxWeightEdt1.setText(binding.setPaxTxt1.text)
            alert.binding.PaxWeightEdt2.setText(binding.setPaxTxt2.text)
            alert.binding.PaxWeightEdt3.setText(binding.setPaxTxt3.text)

            alert.binding.confirmBtn.setOnClickListener {
                setPaxTxt1.text = "${alert.binding.alertPaxWeightEdt1.text}"
                pax1Moment.text = "${dec.format((AppUtil.checkEdit(alert.binding.alertPaxWeightEdt1))*3726)}"
                setPaxTxt2.text = "${alert.binding.PaxWeightEdt2.text}"
                pax2Moment.text = "${dec.format((AppUtil.checkEdit(alert.binding.PaxWeightEdt2))*3726)}"
                setPaxTxt3.text = "${alert.binding.PaxWeightEdt3.text}"
                pax3Moment.text = "${dec.format((AppUtil.checkEdit(alert.binding.PaxWeightEdt3))*3726)}"

                if (alert.binding.PaxWeightEdt2.text.isNullOrBlank()) {
                    fwdPaxLayer2.visibility = View.GONE
                } else {
                    fwdPaxLayer2.visibility = View.VISIBLE
                    fwdPaxLayer3.visibility = View.GONE
                }
                if (!alert.binding.PaxWeightEdt3.text.isNullOrBlank()) {
                    fwdPaxLayer3.visibility = View.VISIBLE
                } else {
                    fwdPaxLayer3.visibility = View.GONE
                }

                alert.dialog.dismiss()
            }


        }

        binding.pilotWeightLayer.setOnClickListener {
            val pilotAlert = PilotWeightAlertDialog(requireContext())
            pilotAlert.myDialog()

            pilotAlert.binding.weightEdt.setText(setPilotWeight.text)
            pilotAlert.binding.weightEdt2.setText(setCoPilotWeight.text)

            pilotAlert.binding.pilotWeightEdtBtn.setOnClickListener {
                setPilotWeight.text = "${pilotAlert.binding.weightEdt.text}"
                pilotMoment.text = "${dec.format((AppUtil.checkEdit(pilotAlert.binding.weightEdt))*2867)}"

                setCoPilotWeight.text = "${pilotAlert.binding.weightEdt2.text}"
                CopilotMoment.text = "${dec.format((AppUtil.checkEdit(pilotAlert.binding.weightEdt2))*2868)}"
                pilotAlert.dialog.dismiss()
            }
        }
        binding.aftLayout.setOnClickListener {
            val Aftalert = AftPaxAlertDialog(requireContext())
            Aftalert.myDialog()

            Aftalert.binding.AftPaxWeightEdt1.setText(setAPaxTxt1.text)
            Aftalert.binding.AftPaxWeightEdt2.setText(setAPaxTxt2.text)
            Aftalert.binding.AftPaxWeightEdt3.setText(setAPaxTxt3.text)

            Aftalert.binding.conFirmBtn.setOnClickListener {
                Toast.makeText(requireContext(), "변경 완료", Toast.LENGTH_SHORT).show()
                setAPaxTxt1.text = "${Aftalert.binding.AftPaxWeightEdt1.text}"
                AftPaxMoment1.text = "${dec.format((AppUtil.checkEdit(Aftalert.binding.AftPaxWeightEdt1))*4616)}"
                setAPaxTxt2.text = "${Aftalert.binding.AftPaxWeightEdt2.text}"
                AftPaxMoment2.text = "${dec.format((AppUtil.checkEdit(Aftalert.binding.AftPaxWeightEdt2))*4616)}"
                setAPaxTxt3.text = "${Aftalert.binding.AftPaxWeightEdt3.text}"
                AftPaxMoment3.text = "${dec.format((AppUtil.checkEdit(Aftalert.binding.AftPaxWeightEdt3))*4616)}"

                if (Aftalert.binding.AftPaxWeightEdt2.text.isNullOrBlank()) {
                    AftPax1.visibility = View.GONE
                } else {
                    AftPax1.visibility = View.VISIBLE
                    AftPax2.visibility = View.GONE
                }
                if (!Aftalert.binding.AftPaxWeightEdt3.text.isNullOrBlank()) {
                    AftPax2.visibility = View.VISIBLE
                } else {
                    AftPax2.visibility = View.GONE
                }
                Aftalert.dialog.dismiss()
            }

        }
        binding.fuelLayout.setOnClickListener {
            val fuelAlert = FuelWeightAlertDialog(requireContext())
            fuelAlert.myDialog()

            fuelAlert.binding.FuelWeightEdt.setText(fuelTankTxt.text)

            fuelAlert.binding.fuelEdtBtn.setOnClickListener {
                fuelTankTxt.text = "${fuelAlert.binding.FuelWeightEdt.text}"
                (requireContext() as MainActivity).mWeightData.fuel = fuelAlert.binding.FuelWeightEdt.text.toString().toInt()

                FuelMoment.text = "${dec.format((AppUtil.checkEdit(fuelAlert.binding.FuelWeightEdt))*4582)}"

                fuelAlert.dialog.dismiss()
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {



            mWeightData = data?.getSerializableExtra("weightData") as WeightData
            (requireContext() as MainActivity).mWeightData = mWeightData
//                  다녀왔을때 메인액티비티에 아래 자료를 넣는다.
            Log.d("asd1",mWeightData.toString())
            Log.d("asd2","${(requireContext() as MainActivity).mWeightData}")


            setPilotWeight.text = "${mWeightData.pilotWeight} KG"
            pilotMoment.text = "${dec.format((mWeightData.pilotWeight)*2867)}"
            setCoPilotWeight.text = "${mWeightData.coPilotWeight} KG"
            CopilotMoment.text = "${dec.format((mWeightData.coPilotWeight)*2868)}"

            setPaxTxt1.text = "${mWeightData.pax1} KG"
            pax1Moment.text = "${dec.format((mWeightData.pax1)*3726)}"
            setPaxTxt2.text = "${mWeightData.pax2} KG"
            pax2Moment.text = "${dec.format((mWeightData.pax2)*3726)}"
            setPaxTxt3.text = "${mWeightData.pax3} KG"
            pax3Moment.text = "${dec.format((mWeightData.pax3)*3726)}"

            setAPaxTxt1.text = "${mWeightData.apax1} KG"
            AftPaxMoment1.text = "${dec.format((mWeightData.apax1)*4616)}"
            setAPaxTxt2.text = "${mWeightData.apax2} KG"
            AftPaxMoment2.text = "${dec.format((mWeightData.apax2)*4616)}"
            setAPaxTxt3.text = "${mWeightData.apax3} KG"
            AftPaxMoment3.text ="${dec.format((mWeightData.apax3)*4616)}"

            fuelTankTxt.text = "${mWeightData.fuel} KG"
            FuelMoment.text = "${dec.format((mWeightData.fuel)*4616)}"


            if (mWeightData.apax2 == 0) {
                AftPax1.visibility = View.GONE
                AftPax2.visibility = View.GONE
            } else {

                if (mWeightData.apax3 == 0) {
                    AftPax1.visibility = View.VISIBLE
                    AftPax2.visibility = View.GONE
                } else {
                    AftPax1.visibility = View.VISIBLE
                    AftPax2.visibility = View.VISIBLE
                }
            }

            if (mWeightData.pax2 == 0) {
                fwdPaxLayer2.visibility = View.GONE
                fwdPaxLayer3.visibility = View.GONE

            } else {
                if (mWeightData.pax3 == 0) {
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