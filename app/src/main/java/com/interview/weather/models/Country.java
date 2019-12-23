package com.interview.weather.models;

public class Country implements Place{
    private String name;

    public Country(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
