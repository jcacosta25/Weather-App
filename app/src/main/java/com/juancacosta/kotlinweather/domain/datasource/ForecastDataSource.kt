package com.juancacosta.kotlinweather.domain.datasource


import com.juancacosta.kotlinweather.domain.model.Forecast
import com.juancacosta.kotlinweather.domain.model.ForecastList

/**
 * Created by jcacosta on 5/20/17.
 *
 */
interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?
}