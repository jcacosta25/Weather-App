package com.juancacosta.kotlinweather.domain.commands

import com.juancacosta.kotlinweather.domain.datasource.ForecastProvider
import com.juancacosta.kotlinweather.domain.model.Forecast

/**
 * Created by jcacosta on 5/20/17.
 *
 */
class RequestDayForecastCommand(
        val id: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()):
        Command<Forecast> {

    override fun execute() = forecastProvider.requestForecast(id)
}