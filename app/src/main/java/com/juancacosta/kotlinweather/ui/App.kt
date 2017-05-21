package com.juancacosta.kotlinweather.ui

import android.app.Application
import com.juancacosta.kotlinweather.extensions.DelegatesExt

/**
 * Created by jcacosta on 5/19/17.
 *
 */

class App : Application(){
    companion object{
        var instance :App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
