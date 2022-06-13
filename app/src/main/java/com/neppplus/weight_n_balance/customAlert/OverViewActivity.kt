package com.neppplus.weight_n_balance.customAlert

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.neppplus.weight_n_balance.R
import java.util.*

class OverViewActivity : AppCompatActivity() {

    var charData = ArrayList<Entry>()
    var lineDataSet = ArrayList<ILineDataSet>()
    var lineData : LineData = LineData()



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_over_view)

        initchartData()
        initChart()

    }
    lateinit var chart : LineChart

    fun initchartData() {
        charData.add(Entry(-240f, 0f))
        charData.add(Entry(150f,200f))
        charData.add(Entry(99f,0f))

        var set = LineDataSet(charData,"set1")
        lineDataSet.add(set)
        lineData = LineData(lineDataSet)
        set.lineWidth = 2f
        set.setDrawValues(false)
        set.highLightColor = Color.TRANSPARENT
        set.mode = LineDataSet.Mode.STEPPED
    }

    fun initChart() {
        chart.run {
            setDrawGridBackground(true)
            setBackgroundColor(Color.WHITE)
            legend.isEnabled = false
        }
        val xAxis = chart.xAxis
        xAxis.setDrawLabels(true)
        xAxis.axisMaximum = -50f
        xAxis.axisMinimum = 300f
        xAxis.labelCount = 35
        xAxis.textColor = Color.BLACK
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawLabels(true)
        xAxis.setDrawAxisLine(true)

        val yLAxis = chart.axisLeft
        yLAxis.axisMaximum = 13000f
        yLAxis.axisMinimum = 6000f

        val yAxisVal = ArrayList(Arrays.asList("F","C","B","A"))
        yLAxis.valueFormatter = IndexAxisValueFormatter(yAxisVal)
        yLAxis.granularity = 1f

        chart!!.description.isEnabled = false
        chart!!.data = lineData
        chart!!.invalidate()
    }
}