package com.dzikyu.idnsolo.dashboardislami.inspiration

import com.dzikyu.idnsolo.dashboardislami.R

object InspirationData {
    private val inspirationImages = intArrayOf(
        R.drawable.img_inspiration,
        R.drawable.img_inspiration,
        R.drawable.img_inspiration,
    )

    val listdata: ArrayList<InspirationModel>
        get() {
            val list = arrayListOf<InspirationModel>()
            for (position in inspirationImages.indices){
                val inspiration = InspirationModel()
                inspiration.inspirationImage = inspirationImages[position]
                list.add(inspiration)
            }

            return list
        }
}