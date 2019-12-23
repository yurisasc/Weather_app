package com.interview.weather.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.interview.weather.models.City;
import com.interview.weather.R;
import com.interview.weather.models.Place;
import com.interview.weather.util.Common;

import java.util.List;

public class CitiesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected final List<Place> places;

    public CitiesAdapter(final List<Place> cities) {
        this.places = cities;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == Common.TYPE_COUNTRY) {
            ViewGroup group = (ViewGroup) inflater.inflate(R.layout.country_item, parent, false);
            return new CountryTextViewHolder(group);
        } else if (viewType == Common.TYPE_CITY) {
            ViewGroup group = (ViewGroup) inflater.inflate(R.layout.city_item, parent, false);
            return new CityTextViewHolder(group);
        }

        throw new RuntimeException("No matching CityTextViewHolder for type " + viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        configureViewHolder((TextViewHolder) holder, position);
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (places.get(position) instanceof City) {
            return Common.TYPE_CITY;
        } else {
            return Common.TYPE_COUNTRY;
        }
    }

    private void configureViewHolder(TextViewHolder vh1, int position) {
        Place place = places.get(position);
        if (place != null) {
            vh1.getTextView().setText(place.getName());
        }
    }

    class CityTextViewHolder extends TextViewHolder {
        CityTextViewHolder(final View itemView) {
            super(itemView, R.id.city_name);
        }
    }

    class CountryTextViewHolder extends TextViewHolder {
        public CountryTextViewHolder(@NonNull View itemView) {
            super(itemView, R.id.country_name);
        }
    }

    abstract class TextViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public TextViewHolder(@NonNull View itemView, int viewId) {
            super(itemView);
            textView=(itemView).findViewById(viewId);
        }

        public TextView getTextView(){
            return textView;
        }
    }
}
