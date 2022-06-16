package com.neppplus.weight_n_balance.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.neppplus.weight_n_balance.MainActivity
import com.neppplus.weight_n_balance.Utils.AppUtil
import com.neppplus.weight_n_balance.Utils.DataUtil
import com.neppplus.weight_n_balance.databinding.FragmentOverViewBinding
import com.neppplus.weight_n_balance.weightData.WeightData
import kotlinx.android.synthetic.main.activity_over_view.*
import kotlinx.android.synthetic.main.fragment_weight.*
import java.util.*

class OverViewFragment : Fragment() {

    lateinit var binding: FragmentOverViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOverViewBinding.inflate(layoutInflater, container, false)
        return binding.root
        DataUtil.getStockData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUIFromData()

        var average = 0F
        for (stock in DataUtil.getStockData()) {
            average += stock.price.toFloat()
        }
//        average /= DataUtil.getStockData().size

        // 그래프에 들어갈 데이터 준비
        val entries = ArrayList<Entry>()
        for (stock in DataUtil.getStockData()) {
            entries.add(Entry(stock.createdAt.toFloat(), stock.price.toFloat()))
        }

        val dataSet = LineDataSet(entries, "").apply {
            setDrawCircles(false)
            color = Color.BLACK
            highLightColor = Color.BLACK
            valueTextSize = 12F
            lineWidth = 1.5F
        }

        val lineData = LineData(dataSet)
        binding.lineChart.run {
            data = lineData
            description.isEnabled = false // 하단 Description Label 제거함
            invalidate() // refresh
        }

        val averageLine = LimitLine(average).apply {
            lineWidth = 1F
            enableDashedLine(4F, 10F, 10F)
            lineColor = Color.BLACK
        }

        // 범례
        binding.lineChart.legend.apply {
            isEnabled = true // 사용하지 않음
        }
        // Y 축
        binding.lineChart.axisLeft.apply {
            // 라벨, 축라인, 그리드 사용하지 않음
            setDrawLabels(false)
            setDrawAxisLine(true)
            setDrawGridLines(false)

//             한계선 추가
            removeAllLimitLines()
            addLimitLine(averageLine)
        }
        binding.lineChart.axisRight.apply {
            // 우측 Y축은 사용하지 않음
            isEnabled = false
        }
        // X 축
        binding.lineChart.xAxis.apply {

            textColor = Color.BLACK
            // 축라인, 그리드 사용하지 않음
            setDrawAxisLine(true)
            setDrawGridLines(true)
        }

        lineChart.getTransformer(YAxis.AxisDependency.RIGHT)
        lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
    }

    override fun onResume() {
        super.onResume()
        setUIFromData()
    }
    fun setUIFromData() {
        var weightData = (requireContext() as MainActivity).mWeightData

        binding.pilotWeightTxt.text = weightData.pilotWeight.toString()
        binding.coPilotWeightTxt.text = weightData.coPilotWeight.toString()
        binding.fuelTank1.text = weightData.fuel.toString()
        Log.d("asd",weightData.toString())

    }
}