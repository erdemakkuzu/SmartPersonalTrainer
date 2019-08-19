package com.example.erdemakkuzu.smartpersonaltrainer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.day_detail.view.*
import kotlinx.android.synthetic.main.workout_day_ticket.view.*

class DayDetailFragment:Fragment(){


     var listofExercises = ArrayList<Exercise>()
     var adapter:ExercisesAdapter?=null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val view:View = inflater.inflate(R.layout.day_detail,container,false)



        listofExercises.add(Exercise("Mekik",10))
        listofExercises.add(Exercise("Şınav",10))
        listofExercises.add(Exercise("Barfix",10))

        adapter = ExercisesAdapter(view.context,listofExercises)
        view.exercisesLv!!.adapter=adapter

        return view
    }


    inner class ExercisesAdapter: BaseAdapter {

        var listofExercises = ArrayList<Exercise>()
        var context: Context?=null

        constructor(context: Context, listofExercises:ArrayList<Exercise>):super(){

            this.listofExercises=listofExercises
            this.context=context

        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            var exercise = listofExercises.get(position)
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflater.inflate(R.layout.workout_day_ticket,null)
            myView.workoutDayNumberTv.text=exercise.exerciseName!!

            myView.setOnClickListener(){


                val intent = Intent(myView.context, YoutubeVideoActivity::class.java)
                startActivity(intent)


            }



            return myView
        }

        override fun getItem(position: Int): Any {
            return listofExercises.get(position)
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listofExercises.size
        }

    }


}