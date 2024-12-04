package com.example.superheroapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hero(
    @StringRes val name: Int,
    @StringRes val descrip: Int,
    @DrawableRes val img: Int
)
