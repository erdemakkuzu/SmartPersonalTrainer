package com.example.erdemakkuzu.smartpersonaltrainer

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.exercise_video_screen.*

class ExerciseVideoFragment : Fragment(){


    companion object {
        val VIDEO_ID : String ="rBhAf-N68l4"
        val YOUTUBE_API_KEY : String = "AIzaSyAXKbyhtCMP9X_Zk9xRlNjTKX3eUrez5YA"

    }

    lateinit var  youtubePlayerInit : YouTubePlayer.OnInitializedListener
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view:View = inflater.inflate(R.layout.exercise_video_screen,container,false)


        initUI()

        youtubePlayer.initialize(YOUTUBE_API_KEY,youtubePlayerInit)


        return  view

    }

    private fun initUI() {

        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, youtubePlayer: YouTubePlayer?, p2: Boolean) {

                youtubePlayer!!.loadVideo(VIDEO_ID)

            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {



            }


        }


    }
}