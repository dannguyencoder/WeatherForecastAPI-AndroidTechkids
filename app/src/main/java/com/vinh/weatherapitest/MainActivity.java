package com.vinh.weatherapitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vinh.weatherapitest.JSONs.WeatherResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private static final String APPID = "ea3672f37f179cf2a6a8e26cda0648a6";
    private static final String UNIT = "metric";


    EditText city_et;
    Button check_btn;
    TextView description_tv, temp_tv, humidity_tv;

    RecyclerView weatherForecast_rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city_et = (EditText) findViewById(R.id.city_edt);
        check_btn = (Button) findViewById(R.id.check_btn);
        description_tv = (TextView) findViewById(R.id.description_tv);
        temp_tv = (TextView) findViewById(R.id.temp_tv);
        humidity_tv = (TextView) findViewById(R.id.humidity_tv);
        weatherForecast_rv = (RecyclerView) findViewById(R.id.weatherForecast_rv);

        check_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (city_et.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Enter City", Toast.LENGTH_SHORT).show();
                }
                else {
                    GetWeatherService getWeatherService = RetrofitFactory.getInstance().create(GetWeatherService.class);


                    getWeatherService.getWeather(city_et.getText().toString(), APPID, UNIT).enqueue(new Callback<WeatherResponse>() {
                        @Override
                        public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                            List<WeatherModel> weatherModels = new ArrayList<WeatherModel>();
                            List<WeatherResponse.DayWeather> dayWeathers = response.body().getList();
                            
                            for (WeatherResponse.DayWeather dayWeather : dayWeathers)
                            {
                                double temp = dayWeather.getMain().getTemp();
                                double humidity = dayWeather.getMain().getHumidity();
                                
                                String desciption = dayWeather.getWeather().get(0).getDescription();
                                
                                WeatherModel weatherModel = new WeatherModel(desciption, temp, humidity);
                                
                                weatherModels.add(weatherModel);

                                Log.d(TAG, "onResponse: " + temp + humidity + desciption);
                            }

                            WeatherForecastAdapter weatherForecastAdapter = new WeatherForecastAdapter(weatherModels);
                            weatherForecast_rv.setAdapter(weatherForecastAdapter);
                            weatherForecast_rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));


                            
                        }

                        @Override
                        public void onFailure(Call<WeatherResponse> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
