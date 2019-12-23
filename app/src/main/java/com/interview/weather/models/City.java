package com.interview.weather.models;

// No need to change
public class City implements Place {
    private final String name;
    private final String countryName;
    private final double latitude;
    private final double longitude;

    public City(final String name, final String countryName, final double latitude, final double longitude) {
        this.name = name;
        this.countryName = countryName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public String getCountryName() {
        return countryName;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

}
