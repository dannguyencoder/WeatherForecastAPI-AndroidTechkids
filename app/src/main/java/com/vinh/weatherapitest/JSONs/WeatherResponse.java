package com.vinh.weatherapitest.JSONs;

import java.util.List;

/**
 * Created by Admin on 20-10-17.
 */

public class WeatherResponse {
    List<DayWeather> list;

    public List<DayWeather> getList() {
        return list;
    }

    public class DayWeather {
        MainDay main;
        List<WeatherDay> weather;

        public MainDay getMain() {
            return main;
        }

        public List<WeatherDay> getWeather() {
            return weather;
        }

        public class MainDay {
            double temp;
            double humidity;

            public double getTemp() {
                return temp;
            }

            public double getHumidity() {
                return humidity;
            }
        }

        public class WeatherDay {
            String description;

            public String getDescription() {
                return description;
            }
        }
    }
}
