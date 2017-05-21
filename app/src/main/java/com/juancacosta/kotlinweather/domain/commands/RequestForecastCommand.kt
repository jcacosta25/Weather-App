package com.juancacosta.kotlinweather.domain.commands

import com.juancacosta.kotlinweather.domain.datasource.ForecastProvider
import com.juancacosta.kotlinweather.domain.model.ForecastList

/**
 * Created by Juan C. Acosta on 5/19/2017.
 *
 */

class RequestForecastCommand(
        val zipCode: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute() = forecastProvider.requestByZipCode(zipCode, DAYS)
}