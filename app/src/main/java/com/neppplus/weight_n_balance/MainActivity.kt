package com.neppplus.weight_n_balance

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.neppplus.weight_n_balance.Adapters.weightAndBalanceAdapter
import com.neppplus.weight_n_balance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mPagerAdapter : weightAndBalanceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPagerAdapter = weightAndBalanceAdapter(this)
        binding.MainViewPager.adapter = mPagerAdapter

    }
}




