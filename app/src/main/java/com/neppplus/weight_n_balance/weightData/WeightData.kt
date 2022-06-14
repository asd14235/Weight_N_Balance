package com.neppplus.weight_n_balance.weightData

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeightData (

    val pilotWeight : String="",
    val coPilotWeight : String="",
    val pax1 : String="",
    val pax2 : String="",
    val pax3 : String="",
    val apax1 : String="",
    val apax2 : String="",
    val apax3 : String="",

) : Serializable
