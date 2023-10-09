package com.dzikyu.idnsolo.dashboardislami.doa.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DoaModel(
    var title : String = "",
    var doa : String = "",
    var latin : String = "",
    var terjemahan : String = "",
    var profile : String = "",
) : Parcelable


