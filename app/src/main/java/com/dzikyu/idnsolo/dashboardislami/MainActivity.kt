package com.dzikyu.idnsolo.dashboardislami

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzikyu.idnsolo.dashboardislami.databinding.ActivityMainBinding
import com.dzikyu.idnsolo.dashboardislami.doa.DoaActivity
import com.dzikyu.idnsolo.dashboardislami.inspiration.InspirationData
import com.dzikyu.idnsolo.dashboardislami.inspiration.InspirationModel
import com.dzikyu.idnsolo.dashboardislami.inspiration.InspirationlistAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerViewInspiration()
        showMenu()
    }

    private fun showMenu() {
        binding.btnDoa.setOnClickListener {
            startActivity(Intent(this, DoaActivity::class.java))
        }
    }

    private fun initRecyclerViewInspiration() {
        val list: ArrayList<InspirationModel> = arrayListOf()
        binding.rvInspiration.setHasFixedSize(true)
        list.addAll(InspirationData.listdata)
        binding.rvInspiration.layoutManager = LinearLayoutManager(this)
        val inspirationAdapter = InspirationlistAdapter(list)
        binding.rvInspiration.adapter = inspirationAdapter
    }
}