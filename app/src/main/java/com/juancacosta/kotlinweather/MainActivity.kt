package com.juancacosta.kotlinweather

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
//import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_rv.*
import javax.xml.datatype.Duration

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
        setContentView(R.layout.activity_main_rv)
        /*setContentView(R.layout.activity_main)
        button.setOnClickListener {
            message.text = "Hello Kotlin!"
            niceToast(message.text.toString())
        }*/

        val  forecastList = findViewById(R.id.forecast_list) as RecyclerView
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(items)
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

}
