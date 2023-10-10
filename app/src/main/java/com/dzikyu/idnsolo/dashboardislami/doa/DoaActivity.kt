package com.dzikyu.idnsolo.dashboardislami.doa

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dzikyu.idnsolo.dashboardislami.R
import com.dzikyu.idnsolo.dashboardislami.databinding.ActivityDoaBinding
import com.dzikyu.idnsolo.dashboardislami.databinding.ActivityMainBinding

class DoaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val actionBar = supportActionBar
        actionBar?.title = "Doa Harian"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        binding =  ActivityDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}