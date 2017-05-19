package com.juancacosta.kotlinweather.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.juancacosta.kotlinweather.R
import com.juancacosta.kotlinweather.domain.model.Forecast
import com.juancacosta.kotlinweather.domain.model.ForecastList
import com.juancacosta.kotlinweather.ui.utils.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * Created by Juan C. Acosta on 5/18/2017.
 *
 */
/*class ForecastListAdapter(val items: List<String>) : Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        //return ViewHolder(TextView(parent.context))
        return ViewHolder(TextView(parent?.context))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.textView?.text = items[position]
    }


    override fun getItemCount(): Int = items.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}*/

class ForecastListAdapter(val items: ForecastList, val itemClick: OnItemClickListener)
    : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        //return ViewHolder(TextView(parent?.context))
        val view = LayoutInflater.from(parent?.ctx)
                .inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindForecast(items[position])
        /*with(items[position]){
            //holder?.textView?.text = "$date - $description - $high/$low"

        }*/
    }

    override fun getItemCount(): Int = items.size

    //class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)'
    class ViewHolder(view: View, val itemClick: OnItemClickListener) :
            RecyclerView.ViewHolder(view) {
        private val iconView = view.find<ImageView>(R.id.icon)
        private val dateView = view.find<TextView>(R.id.date)
        private val descriptionView = view.find<TextView>(R.id.description)
        private val maxTemperature = view.find<TextView>(R.id.maxTemperature)
        private val minTemperature = view.find<TextView>(R.id.minTemperature)

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconURL).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperature.text = "$high"
                minTemperature.text = "$low"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }
}