package com.juancacosta.kotlinweather.data.db

/**
 * Created by jcacosta on 5/19/17.
 *
 */
object CityForecastTable{
    val NAME = "CityForeCast"
    val ID = "_id"
    val CITY = "city"
    val COUNTRY = "country"
}

object DayForecastTable {
    val NAME = "DayForecast"
    val ID = "_id"
    val DATE = "date"
    val DESCRIPTION = "description"
    val HIGH = "high"
    val LOW = "low"
    val ICON_URL = "iconUrl"
    val CITY_ID = "cityId"
}