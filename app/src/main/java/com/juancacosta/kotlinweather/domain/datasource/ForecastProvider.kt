package com.juancacosta.kotlinweather.domain.datasource

import com.juancacosta.kotlinweather.data.db.ForecastDb
import com.juancacosta.kotlinweather.data.server.ForecastServer
import com.juancacosta.kotlinweather.domain.model.Forecast
import com.juancacosta.kotlinweather.domain.model.ForecastList
import com.juancacosta.kotlinweather.extensions.firstResult

/**
 * Created by jcacosta on 5/20/17.
 *
 */

class ForecastProvider(val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {
    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES = listOf(ForecastDb(), ForecastServer())
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = requestToSources {
        val res = it.requestForecastByZipCode(zipCode, todayTimeSpan())
        if (res != null && res.size >= days) res else null
    }

    fun requestForecast(id: Long): Forecast = requestToSources { it.requestDayForecast(id) }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS

    private fun <T : Any> requestToSources(f: (ForecastDataSource) -> T?): T = sources.firstResult { f(it) }
}