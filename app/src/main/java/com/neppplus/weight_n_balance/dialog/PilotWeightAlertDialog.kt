package com.neppplus.weight_n_balance.dialog

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.neppplus.weight_n_balance.R
import com.neppplus.weight_n_balance.databinding.PilotWeightAlertBinding

class PilotWeightAlertDialog (val mContext : Context) {

    val dialog = Dialog(mContext)
    val binding = PilotWeightAlertBinding.inflate(LayoutInflater.from(mContext))

    fun myDialog() {
        dialog.setContentView(binding.root)

        dialog.window?.setLayout(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.decorView?.setBackgroundResource(R.drawable.dialog_background)

        dialog.setCancelable(true)

        binding.pilotWeightSlider.addOnChangeListener { slider, value, fromUser ->
            binding.weightEdt.setText(value.toInt().toString())
        }

        binding.pilotWeightSlider2.addOnChangeListener { slider, value, fromUser ->
            binding.weightEdt2.setText(value.toInt().toString())
        }

        dialog.show()
    }
}