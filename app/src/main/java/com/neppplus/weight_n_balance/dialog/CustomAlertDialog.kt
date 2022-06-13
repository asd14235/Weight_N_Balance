package com.neppplus.weight_n_balance.dialog

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.isVisible
import com.neppplus.weight_n_balance.R
import com.neppplus.weight_n_balance.databinding.ActivityFwdPaxAlertBinding

class CustomAlertDialog(val mContext : Context) {

    val dialog = Dialog(mContext)

    val binding = ActivityFwdPaxAlertBinding.inflate(LayoutInflater.from(mContext))


    fun myDialog () {
        dialog.setContentView(binding.root)

        dialog.window?.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        dialog.window?.decorView?.setBackgroundResource(R.drawable.dialog_background)

        dialog.setCancelable(true)

        binding.PAXWeightSlider.addOnChangeListener { slider, value, fromUser ->
            binding.alertPaxWeightEdt1.setText(value.toInt().toString())
        }

        binding.PAXWeightSlider2.addOnChangeListener { slider, value, fromUser ->
            binding.PaxWeightEdt2.setText(value.toInt().toString()) }

        binding.PAXWeightSlider3.addOnChangeListener { slider, value, fromUser ->
            binding.PaxWeightEdt3.setText(value.toInt().toString()) }

        dialog.show()
        FwdPaxAdd()
    }

    fun FwdPaxAdd() {
        binding.addFPaxBtn.setOnClickListener {
            if (!binding.fpax2Layer.isVisible)
                binding.fpax2Layer.visibility = View.VISIBLE
            binding.addFPaxBtn.visibility = View.GONE
            binding.addFPaxBtn2.visibility = View.VISIBLE
            binding.PAXWeightSlider2.visibility = View.VISIBLE
        }
        binding.addFPaxBtn2.setOnClickListener {
            binding.fPax3Layer.visibility = View.VISIBLE
            binding.addFPaxBtn2.visibility = View.GONE
            binding.addFPaxBtn3.visibility = View.GONE
            binding.PAXWeightSlider3.visibility = View.VISIBLE
        }
    }

}