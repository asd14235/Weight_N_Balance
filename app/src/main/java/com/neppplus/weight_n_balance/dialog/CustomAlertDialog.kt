package com.neppplus.weight_n_balance.dialog

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import com.neppplus.weight_n_balance.R
import com.neppplus.weight_n_balance.databinding.ActivityFwdPaxAlertBinding
import kotlinx.android.synthetic.main.activity_fwd_pax_alert.*
import kotlinx.android.synthetic.main.activity_main.*

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

        dialog.show()
    }


}