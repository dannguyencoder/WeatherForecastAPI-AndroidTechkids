package com.vinh.weatherapitest;

import com.vinh.weatherapitest.JSONs.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Admin on 10/15/2017.
 */

public interface GetWeatherService {
    @GET("data/2.5/forecast?")
    Call<WeatherResponse> getWeather(@Query("q") String city, @Query("appid") String appID, @Query("units") String unit);
}
