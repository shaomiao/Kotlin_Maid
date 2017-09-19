package com.project.domain

import com.project.data.Forecast
import com.project.data.ForecastResult
import java.text.DateFormat
import java.util.*
import com.project.domain.Forecast as ModelForecast

/**
 * Created by shaomiao on 2017/9/19.
 */
public class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,convertForecastListToDomain(forecast.list))
    }
    private fun convertForecastListToDomain(list: List<Forecast>)
            :
            List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast):ModelForecast {
        return ModelForecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt())
    }
    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

//    class RequestForecastCommand(val zipCode: String) :
//            Command<ForecastList> {
//        override fun execute(): ForecastList {
//            val forecastRequest = ForecastRequest(zipCode)
//            return ForecastDataMapper().convertFromDataModel(
//                    forecastRequest.execute())
//        }
//    }
}