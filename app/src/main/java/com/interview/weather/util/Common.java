package com.interview.weather.util;

import com.interview.weather.models.City;
import com.interview.weather.models.Country;
import com.interview.weather.models.Place;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Common {
    // Variables to determine types of ViewHolders
    public static final int TYPE_COUNTRY = 0;
    public static final int TYPE_CITY = 1;

    /**
     * Sort the list of city based on the country.
     * @param list
     * @return
     */
    public static List<City> sortCity(List<City> list) {
        Collections.sort(list, (city, t1) -> city.getCountryName().compareTo(t1.getCountryName()));
        return list;
    }

    /**
     * Add countries to the list of cities,
     * assuming the cities have been sorted by the country.
     * @param list
     * @return
     */
    public static List<Place> addCountries(List<City> list) {
        List<Place> addedCountries = new ArrayList<>();

        Country firstCountry = new Country(list.get(0).getCountryName());
        addedCountries.add(firstCountry);

        for (int i=0; i < list.size() - 1; i++) {
            String countryName1 = list.get(i).getCountryName();
            String countryName2 = list.get(i+1).getCountryName();

            if (countryName1 == countryName2) {
                addedCountries.add(list.get(i));
            } else {
                addedCountries.add(list.get(i));
                addedCountries.add(new Country(list.get(i+1).getCountryName()));
            }
        }
        return addedCountries;
    }

    public static List<Place> groupByCountries(List<City> list) {
        return addCountries(sortCity(list));
    }
}
