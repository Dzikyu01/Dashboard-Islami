package com.dzikyu.idnsolo.dashboardislami.kajian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dzikyu.idnsolo.dashboardislami.R
import com.dzikyu.idnsolo.dashboardislami.databinding.ActivityDetailDoaBinding
import com.dzikyu.idnsolo.dashboardislami.databinding.ActivityDetailKajianBinding
import com.dzikyu.idnsolo.dashboardislami.kajian.model.KajianModel
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class DetailKajianActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailKajianBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailKajianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val kajian = intent.getParcelableExtra<KajianModel>(EXTRA_KAJIAN) as KajianModel
        initKajian(kajian)
    }

    private fun initKajian(kajian: KajianModel) {
        binding.tvPenceramah.text = kajian.speaker
        binding.tvChannelYoutube.text = kajian.channel
        binding.tvJudulKajian.text = kajian.title
        binding.tvDeskripsi.text = kajian.summary

        val youtubeURL: YouTubePlayerView = binding.youtubePlayerView
        lifecycle.addObserver(youtubeURL)
        youtubeURL.addYouTubePlayerListener(
            object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo(kajian.urlVideo, 0f)
                    super.onReady(youTubePlayer)
                }
            }
        )

        binding.fabShare.setOnClickListener {
            val sendKajian = Intent()
            sendKajian.action = Intent.ACTION_SEND
            sendKajian.putExtra(
                Intent.EXTRA_TEXT, "Kajian dengan judul ${kajian.title}" +
                        " disampaikan oleh ${kajian.speaker} dapat dilihat di link berikut ini: " +
                        "https://www.youtube.com/watch?v=${kajian.urlVideo}"
            )
            sendKajian.type = "text/plain"
            startActivity(sendKajian)
        }
    }

    //back
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        val EXTRA_KAJIAN: String = "extra_kajian"
    }
}