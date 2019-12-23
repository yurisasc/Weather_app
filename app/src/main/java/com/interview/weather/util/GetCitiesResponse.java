package com.interview.weather.util;

import com.interview.weather.models.City;

import java.util.List;

// No need to change
public class GetCitiesResponse {

    public final List<City> cities;

    public GetCitiesResponse(final List<City> cities) {
        this.cities = cities;
    }
}
