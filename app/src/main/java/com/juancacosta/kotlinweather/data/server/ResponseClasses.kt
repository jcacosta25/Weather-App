package com.juancacosta.kotlinweather.data.server

/**
 * Created by Juan C. Acosta on 5/19/2017.
 *
 */
data class ForecastResult(val city: com.juancacosta.kotlinweather.data.server.City, val list: List<com.juancacosta.kotlinweather.data.server.Forecast>)

data class City(val id: Long, val name: String, val cord: com.juancacosta.kotlinweather.data.server.Coordinates,
                val country: String, val population:Int)
data class Coordinates(val lon:Float, val lat:Float)

data class Forecast(val dt: Long, val temp: com.juancacosta.kotlinweather.data.server.Temperature, val pressure: Float,
                    val humidity: Int, val weather: List<com.juancacosta.kotlinweather.data.server.Weather>,
                    val speed: Float, val deg: Int, val clouds: Int,
                    val rain: Float)
data class Temperature(val day: Float, val min:Float, val max: Float,
                       val night: Float, val eve:Float,val morn:Float)
data class Weather(val id:Long, val main:String, val description:String, val icon:String)