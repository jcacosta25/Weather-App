package com.juancacosta.kotlinweather.ui.activities

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.juancacosta.kotlinweather.R
import com.juancacosta.kotlinweather.domain.commands.RequestForecastCommand
import com.juancacosta.kotlinweather.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecastList.layoutManager = LinearLayoutManager(this)
        doAsync {
            val result = RequestForecastCommand(66220).execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result){
                    startActivity<DetailActivity>(DetailActivity.ID to it.id,
                            DetailActivity.CITY_NAME to result.city)
                }
            }
        }

        //supportsLollipop { window.statusBarColor(Color.BLACK) }

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

