package com.vinh.weatherapitest;

/**
 * Created by Admin on 20-10-17.
 */

public class WeatherModel {
    public String description;
    public double temp;
    public double humidity;

    public String getDescription() {
        return description;
    }

    public double getTemp() {
        return temp;
    }

    public double getHumidity() {
        return humidity;
    }

    public WeatherModel(String description, double temp, double humidity) {

        this.description = description;
        this.temp = temp;
        this.humidity = humidity;
    }
}
