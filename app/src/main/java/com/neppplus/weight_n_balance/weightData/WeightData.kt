package com.neppplus.weight_n_balance.weightData

import java.io.Serializable

data class WeightData(

    var pilotWeight : Int = 0 ,
    var coPilotWeight: Int = 0 ,
    var pax1: Int=0 ,
    var pax2: Int=0 ,
    var pax3: Int=0 ,
    var apax1: Int=0 ,
    var apax2: Int=0 ,
    var apax3: Int=0 ,
    var fuel: Int=0 ,

    ) : Serializable
