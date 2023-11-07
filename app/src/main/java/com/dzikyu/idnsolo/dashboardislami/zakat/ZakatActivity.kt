package com.dzikyu.idnsolo.dashboardislami.zakat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.dzikyu.idnsolo.dashboardislami.databinding.ActivityZakatBinding
import java.text.NumberFormat
import java.util.Locale

class ZakatActivity : AppCompatActivity() {

    private lateinit var binding : ActivityZakatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZakatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        initHitungZakat()
    }

    private fun initHitungZakat() {
        binding.btnHitung.setOnClickListener { var isEmptyField = false
            val localeID = Locale("in", "ID")
            val formatRupiah: NumberFormat = NumberFormat.getCurrencyInstance(localeID)
            var inputZakat = binding.edtTotalHartaKeseluruhan.text.toString().trim()

            if (inputZakat.isEmpty()) {
                isEmptyField = true
                binding.edtTotalHartaKeseluruhan.error = "Field ini tidak boleh kosong"
            }

            if (!isEmptyField) {
                if (inputZakat.toInt()!! < 92395000) {
                    binding.tvTotalHartaKeseluruhan.text = formatRupiah.format(inputZakat.toInt()!!)
                    binding.tvStatus.text = "Tidak Wajib Zakat"
                    binding.tvZakatYangDikeluarkan.text = formatRupiah.format(0)
                    Toast.makeText(this, "Tidak Wajib Zakat", Toast.LENGTH_SHORT).show()
                } else {
                    binding.tvTotalHartaKeseluruhan.text = formatRupiah.format(inputZakat.toInt()!!)
                    binding.tvStatus.text = "Wajib Zakat"
                    binding.tvZakatYangDikeluarkan.text =
                        formatRupiah.format(inputZakat.toInt()!! * 0.025)
                    Toast.makeText(this, "Wajib Zakat", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)

    }
}