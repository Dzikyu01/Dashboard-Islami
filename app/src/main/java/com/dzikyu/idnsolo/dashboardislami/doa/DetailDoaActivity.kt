package com.dzikyu.idnsolo.dashboardislami.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dzikyu.idnsolo.dashboardislami.databinding.ActivityDetailDoaBinding
import com.dzikyu.idnsolo.dashboardislami.doa.model.DoaModel

class DetailDoaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val doa = intent.getParcelableExtra<DoaModel>(EXTRA_DOA) as DoaModel
        val actionBar = supportActionBar
        actionBar!!.title = doa.title
        actionBar.setDisplayHomeAsUpEnabled(true)

        binding.tvtitle.text = doa.title
        binding.tvarabic.text = doa.doa
        binding.tvlatin.text = doa.latin
        binding.tvterjemahan.text = doa.terjemahan
        binding.tvperawi.text = doa.profile
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    companion object{
        const val EXTRA_DOA = "extra_doa"
    }
}