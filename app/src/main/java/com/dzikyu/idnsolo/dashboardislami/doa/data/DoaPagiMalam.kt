package com.dzikyu.idnsolo.dashboardislami.doa.data

import com.dzikyu.idnsolo.dashboardislami.doa.model.DoaModel

object DoaPagiMalam {
    private val doaTitle = arrayOf(
        "Doa sebelum tidur",
        "Doa bangun tidur",
        "Doa apabila ada yang menakutkan dalam tidur"
    )

    private val doaDoa = arrayOf(
        "اللَّهُمَّ بِاسْمِكَ أَمُوتُ وَأَحْيَا",
        "الْحَمْدُ لِلَّهِ الَّذِي أَحْيَانَا بَعْدَ مَا أَمَاتَنَا وَإِلَيْهِ النُّشُورُ",
        "أَعُوذُ بِكَلِمَاتِ اللَّهِ التَّامَّاتِ مِنْ غَضَبِهِ وَعِقَابِهِ، وَشَرِّ عِبَادِهِ، وَمِنْ هَمَزَاتِ الشَّيَاطِينِ وَأَنْ يَحْضُرُونِ"
    )

    private val doaTerjemahan = arrayOf(
        "Ya Allah, dengan namaMu aku mati dan aku hidup.",
        "Segala puji bagi Allah yang menghidupkanku dan mematikanku dan kepadaNya lah kita dikembalikan.",
        "Aku berlindung dengan kalimat Allah yang sempurna dari kemarahan, siksaan dan kejahatan hamba-hamba-Nya dan dari godaan setan serta jangan sampai setan mendatangiku."
    )

    private val doaLatin = arrayOf(
        "Allahumma bismika amuutu wa ahyaa",
        "Alhamdulillahilladzi ahyaana ba’damaa amaatana wa ilaihin nusyuur",
        "'A'uudzu bikalimaatil-laahit-taammaati min ghadhabihi wa 'iqaabihi, wa sharri 'ibaadihi, wa min hamazaatish-shayaateeni wa an yahdhuruun."
    )

    private val doaProfile = arrayOf(
        "Hadist Riwayat Bukhori",
        "Hadist Riwayat Bukhori",
        "Hadist Riwayat Abu Dawud dan Shohih At-Tirmidzi"
    )

    val listDoaPagiDanMalamData: ArrayList<DoaModel>
        get() {
            val list = arrayListOf<DoaModel>()
            for (position in doaTitle.indices) {
                val doa = DoaModel()
                doa.title = doaTitle[position]
                doa.doa = doaDoa[position]
                doa.terjemahan = doaTerjemahan[position]
                doa.latin = doaLatin[position]
                doa.profile = doaProfile[position]
                list.add(doa)
            }
            return list
        }
}