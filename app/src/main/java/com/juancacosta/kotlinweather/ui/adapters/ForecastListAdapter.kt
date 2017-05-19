package com.juancacosta.kotlinweather.ui.adapters

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.ViewGroup
import android.widget.TextView
import com.juancacosta.kotlinweather.domain.model.ForecastList
import com.juancacosta.kotlinweather.ui.adapters.ForecastListAdapter.ViewHolder

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

class ForecastListAdapter(val items: ForecastList): RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent?.context))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        with(items[position]){
            holder?.textView?.text = "$date - $description - $hight/$low"
        }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}