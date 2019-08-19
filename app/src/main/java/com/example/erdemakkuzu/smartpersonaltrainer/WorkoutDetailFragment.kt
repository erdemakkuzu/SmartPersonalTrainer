package com.example.erdemakkuzu.smartpersonaltrainer

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.workout_day_ticket.view.*
import kotlinx.android.synthetic.main.workout_detail.*
import kotlinx.android.synthetic.main.workout_detail.view.*

class WorkoutDetailFragment: Fragment() {


    var listOfDays = ArrayList<WorkoutDay>()
    var adapter:DaysAdapter?=null




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view:View = inflater.inflate(R.layout.workout_detail,container,false)


        //load Days

        listOfDays.add(WorkoutDay("Day 1",false))
        listOfDays.add(WorkoutDay("Day 2",false))
        listOfDays.add(WorkoutDay("Day 3",false))
        listOfDays.add(WorkoutDay("Day 4",false))
        listOfDays.add(WorkoutDay("Day 5",false))
        listOfDays.add(WorkoutDay("Day 6",false))
        listOfDays.add(WorkoutDay("Day 7",false))
        listOfDays.add(WorkoutDay("Day 8",false))
        listOfDays.add(WorkoutDay("Day 9",false))
        listOfDays.add(WorkoutDay("Day 10",false))
        listOfDays.add(WorkoutDay("Day 11",false))
        listOfDays.add(WorkoutDay("Day 12",false))
        listOfDays.add(WorkoutDay("Day 13",false))
        listOfDays.add(WorkoutDay("Day 14",false))
        listOfDays.add(WorkoutDay("Day 15",false))
        listOfDays.add(WorkoutDay("Day 16",false))
        listOfDays.add(WorkoutDay("Day 17",false))

        adapter= DaysAdapter(view.context,listOfDays)
        view.daynumbersLv!!.adapter=adapter





        return  view
    }

    inner class DaysAdapter:BaseAdapter{

        var listofDays = ArrayList<WorkoutDay>()
        var context:Context?=null

        constructor(context:Context, listofDays:ArrayList<WorkoutDay>):super(){

            this.listofDays=listofDays
            this.context=context

        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            var day = listofDays.get(position)
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflater.inflate(R.layout.workout_day_ticket,null)
            myView.workoutDayNumberTv.text=day.dayName!!

            myView.setOnClickListener{



                val fragment = DayDetailFragment()

                fragmentManager!!.beginTransaction().replace(R.id.workoutDetailLayout,fragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit()

            }

            return myView
        }

        override fun getItem(position: Int): Any {
            return listofDays.get(position)
        }

        override fun getItemId(position: Int): Long {
           return position.toLong()
        }

        override fun getCount(): Int {
           return listofDays.size
        }

    }

}