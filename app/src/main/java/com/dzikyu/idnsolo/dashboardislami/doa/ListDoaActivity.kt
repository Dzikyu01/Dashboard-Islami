package com.dzikyu.idnsolo.dashboardislami.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzikyu.idnsolo.dashboardislami.R
import com.dzikyu.idnsolo.dashboardislami.databinding.ActivityDetailDoaBinding
import com.dzikyu.idnsolo.dashboardislami.databinding.ActivityDetailListDoaBinding
import com.dzikyu.idnsolo.dashboardislami.doa.adapter.DoaListAdapter
import com.dzikyu.idnsolo.dashboardislami.doa.data.DoaEtikaBaik
import com.dzikyu.idnsolo.dashboardislami.doa.data.DoaMakananMinuman
import com.dzikyu.idnsolo.dashboardislami.doa.data.DoaPagiMalam
import com.dzikyu.idnsolo.dashboardislami.doa.data.DoaPerjalanan
import com.dzikyu.idnsolo.dashboardislami.doa.data.DoaRumah
import com.dzikyu.idnsolo.dashboardislami.doa.data.DoaSholat
import com.dzikyu.idnsolo.dashboardislami.doa.model.DoaModel
import java.security.KeyStore.TrustedCertificateEntry

class ListDoaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailListDoaBinding
    lateinit var title:String
    var logo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailListDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = intent.getStringExtra(EXTRA_TITLE).toString()
        logo = intent.getIntExtra(EXTRA_IMAGE,0)

        val actionBar = supportActionBar
        actionBar?.title = intent.getStringExtra(EXTRA_TITLE)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        initRecyclerView(

        )

    }

    private fun initRecyclerView() {
        val list : ArrayList<DoaModel> = arrayListOf()
        when (title){
            getString(R.string.pagi_dan_malam)->{
                list.addAll(DoaPagiMalam.listDoaPagiDanMalamData)
            }
            getString(R.string.doa_rumah) ->{
                list.addAll(DoaRumah.listDoaRumahData)
            }
            getString(R.string.makanan_dan_minuman) ->{
                list.addAll(DoaMakananMinuman.listDoaMakananDanMinumanData)
            }
            getString(R.string.perjalanan) ->{
                list.addAll(DoaPerjalanan.listDoaPerjalananData)
            }
            getString(R.string.doa_sholat) ->{
                list.addAll(DoaSholat.listDoaShalatData)
            }
            getString(R.string.etika_baik) ->{
                list.addAll(DoaEtikaBaik.listDoaEtikaBaikData)
            }
        }

        binding.rvListDoa.hasFixedSize()
        binding.rvListDoa.layoutManager = LinearLayoutManager(this)
        val adapter = DoaListAdapter(list, title, logo)
        binding.rvListDoa.adapter = adapter

    }

    companion object{
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_IMAGE = "extra_image"
    }
}