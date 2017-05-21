package com.juancacosta.kotlinweather.extensions

import android.content.Context
import android.support.v4.content.ContextCompat

/**
 * Created by jcacosta on 5/21/17.
 *
 */
fun Context.color(res:Int): Int = ContextCompat.getColor(this,res)