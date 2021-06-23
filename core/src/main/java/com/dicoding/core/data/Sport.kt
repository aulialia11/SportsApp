package com.dicoding.core.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sport(
    val sportId: String,
    val strSport: String,
    val strFormat: String,
    val strSportThumb: String,
    val strSportDescription: String,
    val isFavorite: Boolean
) : Parcelable