package com.juancacosta.kotlinweather.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.juancacosta.kotlinweather.R
import com.juancacosta.kotlinweather.domain.commands.RequestDayForecastCommand
import com.juancacosta.kotlinweather.domain.model.Forecast
import com.juancacosta.kotlinweather.extensions.color
import com.juancacosta.kotlinweather.extensions.textColor
import com.juancacosta.kotlinweather.extensions.toDateString
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.text.DateFormat


class DetailActivity : AppCompatActivity() {

    companion object{
        val ID = "DetailActivity:id"
        val CITY_NAME = "DetailActivity:cityName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        title = intent.getStringExtra(CITY_NAME)

        doAsync {
            val result = RequestDayForecastCommand(intent.getLongExtra(ID,-1)).execute()
            uiThread { bindForecast(result) }
        }
    }

    private fun bindForecast(forecast: Forecast){
        with(forecast){
            Picasso.with(ctx).load(iconUrl).into(icon)
            supportActionBar?.subtitle = date.toDateString(DateFormat.FULL)
            weatherDescription.text = description
            bindWeather(high to maxTemperature, low to minTemperature)
        }
    }


    private fun bindWeather(vararg views: Pair<Int, TextView>) = views.forEach {
        it.second.text = "${it.first.toString()}"
        it.second.textColor = color(when (it.first) {
            in -50..0 -> android.R.color.holo_red_dark
            in 0..15 -> android.R.color.holo_orange_dark
            else -> android.R.color.holo_green_dark
        })
    }

}
