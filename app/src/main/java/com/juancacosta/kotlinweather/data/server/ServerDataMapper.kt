package com.juancacosta.kotlinweather.data.server

import com.juancacosta.kotlinweather.domain.model.ForecastList
import java.util.Calendar
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.DAYS
import com.juancacosta.kotlinweather.domain.model.Forecast as ModelForecast


/**
 * Created by Juan C. Acosta on 5/19/2017.
 *
 */
class ServerDataMapper {

    fun convertToDomain(zipCode: Long, forecast: ForecastResult) = with(forecast) {
        ForecastList(zipCode, city.name, city.country, convertForecastListToDomain(list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(-1, dt, weather[0].description, temp.max.toInt(), temp.min.toInt(),
                generateIconUrl(weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String): String = "https://raw.githubusercontent.com/"+
            "jcacosta25/WeatherIcons/master/$iconCode.png"
}