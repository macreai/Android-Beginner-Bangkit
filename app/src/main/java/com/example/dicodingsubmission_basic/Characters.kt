package com.example.dicodingsubmission_basic

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Characters (
    val name: String,
    val desc: String,
    val photo: Int,
    val nation: String,
    val constellation: String,
    val weapon: String,
    val occupation: String
    ): Parcelable