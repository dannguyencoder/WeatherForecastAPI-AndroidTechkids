package com.vinh.weatherapitest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 20-10-17.
 */

public class WeatherForecastAdapter extends RecyclerView.Adapter<WeatherForecastAdapter.WeatherForecastViewHolder> {

    List<WeatherModel> weatherModels;

    public WeatherForecastAdapter(List<WeatherModel> weatherModels) {
        this.weatherModels = weatherModels;
    }

    @Override
    public WeatherForecastAdapter.WeatherForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =  LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_weather_forecast, null);
        return new WeatherForecastViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WeatherForecastAdapter.WeatherForecastViewHolder holder, int position) {
        holder.setData(weatherModels.get(position));
    }

    @Override
    public int getItemCount() {
        return weatherModels.size();
    }

    class WeatherForecastViewHolder extends RecyclerView.ViewHolder {
        TextView description_tv;
        TextView temperature_tv;
        TextView humidity_tv;

        public WeatherForecastViewHolder(View itemView) {
            super(itemView);

            description_tv = itemView.findViewById(R.id.description_tv);
            temperature_tv = itemView.findViewById(R.id.temp_tv);
            humidity_tv = itemView.findViewById(R.id.humidity_tv);
        }

        public void setData(WeatherModel weatherModel) {
            description_tv.setText(weatherModel.getDescription());
            temperature_tv.setText(String.valueOf(weatherModel.getTemp()));
            humidity_tv.setText(String.valueOf(weatherModel.getHumidity()));
        }
    }


}
