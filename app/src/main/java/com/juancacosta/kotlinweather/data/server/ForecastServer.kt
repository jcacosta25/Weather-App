package com.juancacosta.kotlinweather.data.server

import com.juancacosta.kotlinweather.data.db.ForecastDb
import com.juancacosta.kotlinweather.domain.datasource.ForecastDataSource
import com.juancacosta.kotlinweather.domain.model.ForecastList

/**
 * Created by jcacosta on 5/20/17.
 *
 */
class ForecastServer(val dataMapper: ServerDataMapper = ServerDataMapper(),
                     val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }

    override fun requestDayForecast(id: Long) = throw UnsupportedOperationException()
}