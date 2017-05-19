package com.juancacosta.kotlinweather.domain.model

/**
 * Created by Juan C. Acosta on 5/19/2017.
 *
 */
data class ForecastList(val city: String, val country:String,
                        val dailyForecast:List<Forecast>){
    val size: Int get() = dailyForecast.size
    operator fun get(position:Int):Forecast = dailyForecast[position]
}
data class Forecast(val date: String, val description: String, val hight: Int, val low: Int)