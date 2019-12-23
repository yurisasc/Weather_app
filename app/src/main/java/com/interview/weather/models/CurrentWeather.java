package com.interview.weather.models;

// No need to change
public class CurrentWeather {
    private final String longDescription;
    private final float feelsLikeCelsius;
    private final short rainChancePercent;
    private final short humidityPercent;
    private final String airPressureDescription;
    private final String windDirection;
    private final float windSpeed;

    public CurrentWeather(
            final String longDescription,
            final float feelsLikeCelsius,
            final short rainChancePercent,
            final short humidityPercent,
            final String airPressureDescription,
            final String windDirection,
            final float windSpeed) {
        this.longDescription = longDescription;
        this.feelsLikeCelsius = feelsLikeCelsius;
        this.rainChancePercent = rainChancePercent;
        this.humidityPercent = humidityPercent;
        this.airPressureDescription = airPressureDescription;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public float getFeelsLikeCelsius() {
        return feelsLikeCelsius;
    }

    public short getRainChancePercent() {
        return rainChancePercent;
    }

    public short getHumidityPercent() {
        return humidityPercent;
    }

    public String getAirPressureDescription() {
        return airPressureDescription;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public float getWindSpeed() {
        return windSpeed;
    }
}
