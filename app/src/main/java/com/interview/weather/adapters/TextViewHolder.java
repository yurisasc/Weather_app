package com.interview.weather.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class TextViewHolder extends RecyclerView.ViewHolder {
    protected TextView textView;

    public TextViewHolder(View itemView, int viewId) {
        super(itemView);
        textView=(itemView).findViewById(viewId);
    }

    public TextView getTextView(){
        return textView;
    }
}
