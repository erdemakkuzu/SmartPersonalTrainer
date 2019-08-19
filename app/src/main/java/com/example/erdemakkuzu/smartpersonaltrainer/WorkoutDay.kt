package com.example.erdemakkuzu.smartpersonaltrainer

class WorkoutDay{

    var dayName:String?=null
    var isDone:Boolean?=false

    constructor(dayName: String?, isDone: Boolean?) {
        this.dayName = dayName
        this.isDone = isDone
    }
}