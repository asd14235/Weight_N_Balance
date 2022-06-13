package com.neppplus.weight_n_balance.Adapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.neppplus.weight_n_balance.MainActivity
import com.neppplus.weight_n_balance.R
import com.neppplus.weight_n_balance.customAlert.OverViewActivity

class weightAndBalanceAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MainActivity()
            else -> OverViewActivity()
        }
    }
}