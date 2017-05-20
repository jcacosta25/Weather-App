package com.juancacosta.kotlinweather.ui.activities

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.juancacosta.kotlinweather.domain.commands.RequestForecastCommand
import com.juancacosta.kotlinweather.ui.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        forecastList.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand("66220").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result){toast(it.date)}
            }
        }

        supportsLollipop { window.statusBarColor(Color.BLACK) }


    }
    fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT){
        Toast.makeText(this,message,duration).show()
    }

    inline fun supportsLollipop(code: () -> Unit){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            code()
        }
    }

}

private operator fun  Int.invoke(black: Int) {}
