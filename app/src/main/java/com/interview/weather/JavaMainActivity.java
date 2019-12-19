package com.interview.weather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
            citiesList.setAdapter(new CitiesAdapter(response.cities));
        }
    }

    private static class CitiesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private final List<City> cities;

        private CitiesAdapter(final List<City> cities) {
            this.cities = cities;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {

            RecyclerView.ViewHolder viewHolder;
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            View v1 = inflater.inflate(R.layout.city_item, parent, false);
            viewHolder = new ViewHolder(v1);

            return viewHolder;
        }


        @Override
        public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
            ViewHolder vh = (ViewHolder) holder;
            configureViewHolder(vh, position);
        }

        @Override
        public int getItemCount() {
            return cities.size();
        }


        // View Holders

        static class ViewHolder extends RecyclerView.ViewHolder {
            private TextView textView;
            ViewHolder(final View itemView) {
                super(itemView);
                textView=(itemView).findViewById(R.id.city_name);
            }

            public TextView getTextView() {
                return textView;
            }
        }

        private void configureViewHolder(ViewHolder vh1, int position) {
            City city = (City) cities.get(position);
            if (city != null) {
                vh1.getTextView().setText(city.name);
            }
        }
    }
}
