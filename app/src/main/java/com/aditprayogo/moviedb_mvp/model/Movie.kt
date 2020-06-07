package com.aditprayogo.moviedb_mvp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var id: Int,


    @SerializedName("poster_path") var photo:String,

    var title:String,

    var overview:String,

    var rating:Double

) : Parcelable