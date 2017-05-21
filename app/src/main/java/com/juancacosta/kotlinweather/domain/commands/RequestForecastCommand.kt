package com.juancacosta.kotlinweather.domain.commands

import com.juancacosta.kotlinweather.data.server.ForecastRequest
import com.juancacosta.kotlinweather.domain.mappers.ForecastDataMapper
import com.juancacosta.kotlinweather.domain.model.ForecastList

/**
 * Created by Juan C. Acosta on 5/19/2017.
 *
 */
class RequestForecastCommand(private val zipCode: Long): Command<ForecastList>{
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(zipCode,forecastRequest.execute())
    }
}