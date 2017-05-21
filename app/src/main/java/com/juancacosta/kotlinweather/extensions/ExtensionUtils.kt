package com.juancacosta.kotlinweather.extensions

import java.text.DateFormat
import java.util.Locale

/**
 * Created by jcacosta on 5/21/17.
 *
 */
fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM):String{
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}