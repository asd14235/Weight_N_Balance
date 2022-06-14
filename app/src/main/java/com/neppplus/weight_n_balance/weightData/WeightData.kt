package com.neppplus.weight_n_balance.weightData

import java.io.Serializable

data class WeightData(

    val pilotWeight : Int = 0 ,
    val coPilotWeight: Int=0 ,
    val pax1: Int=0 ,
    val pax2: Int=0 ,
    val pax3: Int=0 ,
    val apax1: Int=0 ,
    val apax2: Int=0 ,
    val apax3: Int=0 ,
    val fuel: Int=0 ,

    ) : Serializable
