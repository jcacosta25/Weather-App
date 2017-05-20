package com.juancacosta.kotlinweather.ui.activities

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.juancacosta.kotlinweather.R.id
import com.juancacosta.kotlinweather.R.layout
import com.juancacosta.kotlinweather.data.ForecastRequest
import com.juancacosta.kotlinweather.domain.commands.RequestForecastCommand
import com.juancacosta.kotlinweather.domain.model.Forecast
import com.juancacosta.kotlinweather.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.Date
import java.util.concurrent.Executors

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/28",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy -21/10"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main_rv)
        /*setContentView(R.layout.activity_main)
        button.setOnClickListener {
            message.text = "Hello Kotlin!"
            niceToast(message.text.toString())
        }*/

        val  forecastList = findViewById(id.forecast_list) as RecyclerView
        forecastList.layoutManager = LinearLayoutManager(this)
        //forecastList.adapter = ForecastListAdapter(items)


        /*val url = "http://api.openweathermap.org/data/2.5/forecast/daily?" +
                "APPID=15646a06818f61f7b8d7823ca833e1ce&q=94043&mode=json&units=metric&cnt=7"
        val executor = Executors.newScheduledThreadPool(4)
        async(executor){
            niceToast("Hello")
        }*/

        /*doAsync {
            ForecastRequest(url).run()
            uiThread { toast("Request performed") }
        }*/

        /*val f1 = Forecast(Date(),27.5f,"Shiny day")
        val f2 = f1.copy(temperature = 30f)
        //val (date, temperature, details) = f1
        val date = f1.component1()
        val temperature = f1.component2()
        val details = f1.component3()*/

        doAsync {
            val result = RequestForecastCommand("66220").execute()
            uiThread {
                // Simple Text Request
                // forecastList.adapter = ForecastListAdapter(result)
                // REQUEST WITH CUSTOM
                /*forecastList.adapter = ForecastListAdapter(result, object:ForecastListAdapter.OnItemClickListener {
                    override fun invoke(forecast: Forecast) {
                        niceToast(forecast.date)
                    }
                })*/

                // Long Lambda
                //forecastList.adapter = ForecastListAdapter(result){forecast -> toast(forecast.date)}
                forecastList.adapter = ForecastListAdapter(result){toast(it.date)}
            }
        }


    }
    // function with Method Toast
    fun niceToast(message: String, tag: String = MainActivity::class.java.simpleName,
                  length: Int = Toast.LENGTH_SHORT){
        Toast.makeText(this,"[$tag] $message",length).show()
    }

    fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT){
        Toast.makeText(this,message,duration).show()
    }

    //function with Return
    fun add (x: Int, y: Int) : Int {
        return x+y
    }

    fun add1(x: Int, y: Int) :Int = x+y

    //data class Forecast(val date: Date, val temperature: Float, val details: String)

}
