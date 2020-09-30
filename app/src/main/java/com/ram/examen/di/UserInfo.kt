package com.ram.examen.di

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserInfo(
    val userName: String,
    val userPassword: String
) : Parcelable