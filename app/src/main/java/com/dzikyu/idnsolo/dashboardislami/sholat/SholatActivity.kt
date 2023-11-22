package com.dzikyu.idnsolo.dashboardislami.sholat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.dzikyu.idnsolo.dashboardislami.R
import com.dzikyu.idnsolo.dashboardislami.databinding.ActivitySholatBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class SholatActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySholatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySholatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        initSholatView()
        getPrayTimeData("1411")
    }

    private fun getPrayTimeData(location: String) {
        val calendar = Calendar.getInstance()
        val tanggal = calendar.get(Calendar.DAY_OF_MONTH)
        val tahun = calendar.get(Calendar.YEAR)
        val bulan = calendar.get(Calendar.MONTH)
        val client = AsyncHttpClient()
        val url = "https://api.myquran.com/v1/sholat/jadwal/$location/$tahun/$bulan/$tanggal"
        Log.d("SholatActivity","getPrayTimeData: $url")

        client.get(url,object :AsyncHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?
            ) {
                binding.pbJadwalSholat.visibility = View.INVISIBLE
                val responseData = responseBody?.let {String(it)}

                try {
                    // 1. mengambil seluruh data
                    val responObject = JSONObject(responData.toString())
                    // cek apakah data terambil
                    Log.d("JadwalSholatActivity", "Data JSON: $responObject")
                    // ambil bagian data
                    val data = responObject.getJSONObject("data")
                    // tampilkan lokasi dalam data ke UI
                    binding.tvLocation.text = data.getString("lokasi")
                    // mengambil bagian jadwal
                    val jadwal = data.getJSONObject("jadwal")
                    // cek apakah data terambil
                    Log.d("JadwalSholatActivity", "Jadwal : $jadwal")
                    // tampilkan data jadwal ke komponen UI
                    binding.tvPrayTimeSubuh.text = jadwal.getString("subuh")
                    binding.tvPrayTimeSunrise.text = jadwal.getString("terbit")
                    binding.tvPrayTimeDzuhur.text = jadwal.getString("dzuhur")
                    binding.tvPrayTimeAshar.text = jadwal.getString("ashar")
                    binding.tvPrayTimeMaghrib.text = jadwal.getString("maghrib")
                    binding.tvPrayTimeIsya.text = jadwal.getString("isya")
                } catch (error: Exception){
                    Toast.makeText(this@SholatActivity, error.message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                Toast.makeText(this@SholatActivity, error?.message , Toast.LENGTH_SHORT).show()
            }

        })
//        tes
    }


    private fun initSholatView() {
        val waktu = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault())
        val formattedDate = dateFormat.format(waktu)

        //menampilkan tanggal sekarang
        binding.tvDatePray.text = formattedDate

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
