package com.juancacosta.kotlinweather.domain.mappers

import com.juancacosta.kotlinweather.data.server.Forecast
import com.juancacosta.kotlinweather.data.server.ForecastResult
import com.juancacosta.kotlinweather.domain.model.ForecastList
import java.util.Calendar
import java.util.concurrent.TimeUnit
import com.juancacosta.kotlinweather.domain.model.Forecast as ModelForecast


/**
 * Created by Juan C. Acosta on 5/19/2017.
 *
 */
class ForecastDataMapper {

    fun convertFromDataModel(zipCode:Long,forecast: ForecastResult) = with(forecast) {
        ForecastList(zipCode,city.name,city.country,convertForecastListToDomain(list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(dt, forecast.weather[0].description,
                forecast.temp.max.toInt(), forecast.temp.min.toInt(),
                generateIconUrl(forecast.weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String): String = "https://raw.githubusercontent.com/"+
            "jcacosta25/WeatherIcons/master/$iconCode.png"
}