package com.example.erdemakkuzu.smartpersonaltrainer

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.choose_workout.*
import kotlinx.android.synthetic.main.choose_workout.view.*

class ChoseWorkoutFragment:Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val view:View = inflater.inflate(R.layout.choose_workout,container,false)



        view.workoutImg.setOnClickListener { view ->

            val fragment = WorkoutDetailFragment()

            Log.d("Sa","sa")
            fragmentManager!!.popBackStack()
            fragmentManager!!.beginTransaction().replace(R.id.chooseWorkoutLayout,fragment).addToBackStack("WorkoutDetailFragment").commit()

        }

       /*
*/

       return view


    }





}