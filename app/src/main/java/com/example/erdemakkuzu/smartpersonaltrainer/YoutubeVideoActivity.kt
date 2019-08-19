package com.example.erdemakkuzu.smartpersonaltrainer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.exercise_video_screen.*

class YoutubeVideoActivity : YouTubeBaseActivity() {


    companion object {
        val VIDEO_ID : String ="rBhAf-N68l4"
        val YOUTUBE_API_KEY : String = "AIzaSyAXKbyhtCMP9X_Zk9xRlNjTKX3eUrez5YA"

    }

    lateinit var  youtubePlayerInit : YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercise_video_screen)

        initUI()

        youtubePlayer.initialize(ExerciseVideoFragment.YOUTUBE_API_KEY,youtubePlayerInit)

        stopVideoButton.setOnClickListener(){

            finish( )

        }



    }

    private fun initUI() {
        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, youtubePlayer: YouTubePlayer?, p2: Boolean) {

                youtubePlayer!!.loadVideo(ExerciseVideoFragment.VIDEO_ID)

            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {



            }


        }

    }
}
