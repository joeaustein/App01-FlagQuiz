package com.example.app01_flagquiz.util

import com.example.app01_flagquiz.R
import com.example.app01_flagquiz.model.Flag

object Constants {
    const val USER_NAME = "user_name"
    const val SCORE = "score"

    fun getFlags(): ArrayList<Flag> {
        return arrayListOf(
            Flag("Argentina", R.drawable.argentina),
            Flag("Armênia", R.drawable.armenia),
            Flag("Austrália", R.drawable.australia),
            Flag("Áustria", R.drawable.austria),
            Flag("Bahamas", R.drawable.bahamas),
            Flag("Bolívia", R.drawable.bolivia),
            Flag("Brasil", R.drawable.brasil),
            Flag("Bulgária", R.drawable.bulgaria),
            Flag("Canadá", R.drawable.canada),
            Flag("Chile", R.drawable.chile),
            Flag("China", R.drawable.china),
            Flag("Colômbia", R.drawable.colombia),
            Flag("Costa Rica", R.drawable.costa_rica),
            Flag("Cuba", R.drawable.cuba),
            Flag("México", R.drawable.mexico)
        )
    }
}
