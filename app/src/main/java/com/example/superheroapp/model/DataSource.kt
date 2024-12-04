package com.example.superheroapp.model

import com.example.superheroapp.R

class DataSource {
    fun loadHeroes(): List<Hero>{
        return listOf(
            Hero(R.string.hero1, R.string.descrip1, R.drawable.android_superhero1),
            Hero(R.string.hero2, R.string.descrip2, R.drawable.android_superhero2),
            Hero(R.string.hero3, R.string.descrip3, R.drawable.android_superhero3),
            Hero(R.string.hero4, R.string.descrip4, R.drawable.android_superhero4),
            Hero(R.string.hero5, R.string.descrip5, R.drawable.android_superhero5),
            Hero(R.string.hero6, R.string.descrip6, R.drawable.android_superhero6)
        )
    }

}