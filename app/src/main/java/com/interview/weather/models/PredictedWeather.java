package com.interview.weather.models;

// No need to change
public class PredictedWeather {
    private final float minTempCelsius;
    private final float maxTempCelsius;
    private final String shortDescription;

    public PredictedWeather(final float minTempCelsius, final float maxTempCelsius, final String shortDescription) {
        this.minTempCelsius = minTempCelsius;
        this.maxTempCelsius = maxTempCelsius;
        this.shortDescription = shortDescription;
    }

    public float getMinTempCelsius() {
        return minTempCelsius;
    }

    public float getMaxTempCelsius() {
        return maxTempCelsius;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
