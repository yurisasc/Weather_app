package com.interview.weather.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.interview.weather.models.City;
import com.interview.weather.R;

import java.util.List;

public class CitiesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected final List<City> cities;

    public CitiesAdapter(final List<City> cities) {
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

    private void configureViewHolder(ViewHolder vh1, int position) {
        City city = (City) cities.get(position);
        if (city != null) {
            vh1.getTextView().setText(city.name);
        }
    }

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
}
