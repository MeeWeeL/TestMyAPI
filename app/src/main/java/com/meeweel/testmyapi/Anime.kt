package com.meeweel.testmyapi;

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    var title: String,
    var description: String,
    var image: String
) : Parcelable