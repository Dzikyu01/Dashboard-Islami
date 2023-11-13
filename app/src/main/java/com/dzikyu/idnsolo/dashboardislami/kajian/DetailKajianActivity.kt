package com.dzikyu.idnsolo.dashboardislami.kajian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dzikyu.idnsolo.dashboardislami.R
import com.dzikyu.idnsolo.dashboardislami.databinding.ActivityDetailDoaBinding
import com.dzikyu.idnsolo.dashboardislami.databinding.ActivityDetailKajianBinding

class DetailKajianActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailKajianBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailKajianBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        val EXTRA_KAJIAN: String = "extra_kajian"
    }
}