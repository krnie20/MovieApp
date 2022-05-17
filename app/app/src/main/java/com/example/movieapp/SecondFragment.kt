package com.example.movieapp

import android.content.res.Configuration
import android.os.Bundle
import android.telephony.mbms.DownloadRequest
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val youtubePlayer = view.findViewById<YouTubePlayerView>(R.id.tvSecondFragment_youtube_player)
        lifecycle.addObserver(youtubePlayer)

        val data = arguments
        val videoId = data?.get("videoId")
        //var videoId = data!!.getString("video_id")

        youtubePlayer.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                if (videoId != null) {
                    youTubePlayer.loadVideo(videoId.toString(), 0F)
                }
                youTubePlayer.pause()
            }
        })

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        }

    override fun onStart() {
        super.onStart()

    }
    }
