package com.project.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.project.R
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity() {


    /**
     * immutable 可以接受任何类型的vararg(可变长的参数) 可以自动推断出类型
     *
     * setOf  arrayListOf 或者 hashSetOf
     */
    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - TRAPPED IN WEATHERSTATION -23/18",
            "Sun 6/29 - Sunny - 29/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val forecastList: RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(items)
    }


    class ForecastListAdapter(val items: List<String>) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(TextView(parent.context))
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.text.text = items[position]
        }

        override fun getItemCount(): Int = items.size


        class ViewHolder(val text: TextView) : RecyclerView.ViewHolder (text)

    }

    public class Person {
        var name: String = ""
        get()  = field.toUpperCase()
        set(value) {
            field = "Name:$value"
        }
    }


}

