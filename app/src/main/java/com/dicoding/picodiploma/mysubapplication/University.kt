package com.dicoding.picodiploma.mysubapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class University(
    val name: String,
    val description: String,
    val photo: Int
) :Parcelable
