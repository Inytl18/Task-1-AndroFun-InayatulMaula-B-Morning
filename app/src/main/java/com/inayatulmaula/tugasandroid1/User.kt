package com.inayatulmaula.tugasandroid1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class User(
    val name:String,
    val pass:String
):Parcelable
