package com.dzikyu.idnsolo.dashboardislami.kajian.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class KajianModel(
    var thumbnail : Int = 0,
    var channel : String = "",
    var speaker : String = "",
    var title : String = "",
    var urlVideo : String = "",
    var summary : String = "",
) : Parcelable