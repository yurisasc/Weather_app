package com.interview.weather.util;

import com.interview.weather.models.CurrentWeather;
import com.interview.weather.models.PredictedWeather;

import java.util.Map;

// No need to change
public class GetWeatherForCityResponse {

    public final CurrentWeather currentWeather;
    public final Map<String, PredictedWeather> predictedWeatherForDays;

    public GetWeatherForCityResponse(
            final CurrentWeather currentWeather,
            final Map<String, PredictedWeather> predictedWeatherForDays) {
        this.currentWeather = currentWeather;
        this.predictedWeatherForDays = predictedWeatherForDays;
    }
}
