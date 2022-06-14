package com.neppplus.weight_n_balance.dialog

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.neppplus.weight_n_balance.R
import com.neppplus.weight_n_balance.databinding.FuelWeightAlertBinding
import com.neppplus.weight_n_balance.databinding.PilotWeightAlertBinding

class FuelWeightAlertDialog (val mContext : Context) {

    val dialog = Dialog(mContext)
    val binding = FuelWeightAlertBinding.inflate(LayoutInflater.from(mContext))

    fun myDialog() {
        dialog.setContentView(binding.root)

        dialog.window?.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.decorView?.setBackgroundResource(R.drawable.dialog_background)

        dialog.setCancelable(true)

        binding.FuelWeightSlider.addOnChangeListener { slider, value, fromUser ->
            binding.FuelWeightEdt.setText(value.toInt().toString())
        }
        dialog.show()
    }
}