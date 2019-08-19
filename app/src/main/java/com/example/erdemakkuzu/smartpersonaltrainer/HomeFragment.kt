package com.example.erdemakkuzu.smartpersonaltrainer

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.choose_workout.*
import kotlinx.android.synthetic.main.home_main.*
import kotlinx.android.synthetic.main.home_main.view.*

class HomeFragment:Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val view: View = inflater!!.inflate(R.layout.home_main, container, false)

        view.choseAnotherWorkout.setOnClickListener(View.OnClickListener {


            val fragment = ChoseWorkoutFragment()


            fragmentManager!!.beginTransaction()
                    .replace(R.id.contentMain,fragment).commit()



        })







        return view
    }
}