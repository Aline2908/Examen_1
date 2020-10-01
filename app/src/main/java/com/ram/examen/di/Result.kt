package com.ram.examen.di

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(
    val result: Int
): Parcelable