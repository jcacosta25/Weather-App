package com.juancacosta.kotlinweather.domain.model

/**
 * Created by Juan C. Acosta on 5/19/2017.
 *
 */
data class ForecastList(val id: Long, val city: String, val country: String,
                        val dailyForecast: List<Forecast>) {

    val size: Int
        get() = dailyForecast.size

    operator fun get(position: Int) = dailyForecast[position]
}

data class Forecast(val date: Long, val description: String, val high: Int, val low: Int,
                    val iconUrl: String)