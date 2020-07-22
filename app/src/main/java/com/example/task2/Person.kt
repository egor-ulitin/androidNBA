package com.example.task2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Person() : Parcelable {
    var name:String?=null
    var surname:String?=null
    var age:Int?=null
    var urlImage: String?= null

    constructor(name: String?, surname: String?, age: Int?, urlImage: String?) : this() {
        this.name = name
        this.surname = surname
        this.age = age
        this.urlImage = urlImage
    }
}