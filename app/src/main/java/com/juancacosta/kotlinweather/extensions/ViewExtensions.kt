package com.juancacosta.kotlinweather.extensions

import android.content.Context
import android.view.View
import android.widget.TextView

/**
 * Created by Juan C. Acosta on 5/19/2017.
 *
 */
val View.ctx: Context
    get() = context

var TextView.textColor: Int
    get() = currentTextColor
    set(v) = setTextColor(v)