package com.example.app01_flagquiz.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Flag(
    val name: String,
    val imageResId: Int
) : Parcelable