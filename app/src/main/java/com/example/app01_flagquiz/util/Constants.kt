package com.example.app01_flagquiz.util

import com.example.app01_flagquiz.R
import com.example.app01_flagquiz.model.Flag

object Constants {

    fun getFlags(): ArrayList<Flag> {
        return arrayListOf(
            Flag("argentina", R.drawable.argentina),
            Flag("armenia", R.drawable.armenia),
            Flag("australia", R.drawable.australia),
            Flag("austria", R.drawable.austria),
            Flag("bahamas", R.drawable.bahamas),
            Flag("bolivia", R.drawable.bolivia),
            Flag("brasil", R.drawable.brasil),
            Flag("bulgaria", R.drawable.bulgaria),
            Flag("canada", R.drawable.canada),
            Flag("chile", R.drawable.chile),
            Flag("china", R.drawable.china),
            Flag("colombia", R.drawable.colombia),
            Flag("costarica", R.drawable.costaRica),
            Flag("cuba", R.drawable.cuba)
        )
    }
}