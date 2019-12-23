package com.interview.weather;

import android.os.Bundle;

import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.interview.weather.network.WeatherNetworkClient;
import com.interview.weather.network.WeatherNetworkClientImpl;
import com.interview.weather.adapters.CitiesAdapter;
import com.interview.weather.util.Common;
import com.interview.weather.util.GetCitiesResponse;

public class JavaMainActivity extends AppCompatActivity {

    private WeatherNetworkClient weatherNetworkClient;

    private RecyclerView citiesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        weatherNetworkClient = new WeatherNetworkClientImpl();
        setContentView(R.layout.activity_main);

        citiesList = findViewById(R.id.cities_list);
        citiesList.setLayoutManager(new LinearLayoutManager(this));

        GetCitiesResponse response = null;
        try {
            response = weatherNetworkClient.waitForCities();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (response != null) {
            citiesList.setAdapter(new CitiesAdapter(Common.groupByCountries(response.cities)));
        }
    }

}
