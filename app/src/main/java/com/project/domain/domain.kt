package com.project.domain

/**
 * Created by zzz on 2017/9/19.
 */
data class ForecastList(val city:String, val country:String, val dailyForecast: List<com.project.domain.Forecast>)
data class Forecast(val date:String,val description:String,val high:Int,val low:Int)