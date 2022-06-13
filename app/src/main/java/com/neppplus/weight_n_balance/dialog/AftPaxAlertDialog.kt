package com.neppplus.weight_n_balance.dialog

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.isVisible
import com.neppplus.weight_n_balance.R
import com.neppplus.weight_n_balance.databinding.AftPaxWeightAlertBinding

class AftPaxAlertDialog(val mContext : Context) {

    val dialog = Dialog(mContext)
    val binding = AftPaxWeightAlertBinding.inflate(LayoutInflater.from(mContext))

    fun myDialog() {
        dialog.setContentView(binding.root)

        dialog.window?.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.decorView?.setBackgroundResource(R.drawable.dialog_background)

        dialog.setCancelable(true)

        binding.AftPAXWeightSlider1.addOnChangeListener { slider, value, fromUser ->
            binding.AftPaxWeightEdt1.setText(value.toInt().toString())
        }

        binding.AftPAXWeightSlider2.addOnChangeListener { slider, value, fromUser ->
            binding.AftPaxWeightEdt2.setText(value.toInt().toString())
        }
        binding.AftPAXWeightSlider3.addOnChangeListener { slider, value, fromUser ->
            binding.AftPaxWeightEdt3.setText(value.toInt().toString())
        }

        dialog.show()
        AftPaxAdd()
    }

    fun AftPaxAdd() {
        binding.AftPaxAddBtn1.setOnClickListener {
            if (!binding.AftPaxLayer2.isVisible)
                binding.AftPaxLayer2.visibility = View.VISIBLE
            binding.AftPaxAddBtn1.visibility = View.GONE
            binding.AftPaxAddBtn2.visibility = View.VISIBLE
            binding.AftPAXWeightSlider2.visibility = View.VISIBLE
        }
        binding.AftPaxAddBtn2.setOnClickListener {
            binding.AftPaxLayer3.visibility = View.VISIBLE
            binding.AftPaxAddBtn2.visibility = View.GONE
            binding.AftPaxAddBtn3.visibility = View.GONE
            binding.AftPAXWeightSlider3.visibility = View.VISIBLE
        }
    }
}