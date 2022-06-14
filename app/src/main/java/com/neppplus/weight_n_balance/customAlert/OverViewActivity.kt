package com.neppplus.weight_n_balance.customAlert

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.neppplus.weight_n_balance.Utils.DataUtil
import com.neppplus.weight_n_balance.databinding.ActivityOverViewBinding
import java.util.*

class OverViewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = ActivityOverViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}

