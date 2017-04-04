package com.example.adminibm.weatherapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import models.Weather;
import models.WeatherCondition;

import static android.R.attr.data;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    ArrayList<Weather> weatherList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherList.add(new Weather("Dublin", 10, WeatherCondition.CLOUDY));
        weatherList.add(new Weather("London", 5, WeatherCondition.RAIN));
        weatherList.add(new Weather("Madrid", 30, WeatherCondition.SUNNY));

        // initialise spinner with cities from data
        Spinner spinner = (Spinner) findViewById(R.id.cityspinner);
        List<String> cities = new ArrayList<> ();
        for (int i = 0; i < weatherList.size(); i++)
        {
            cities.add(weatherList.get(i).getCity());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // hook in handler for selections on spinner
        spinner.setOnItemSelectedListener(this);
    }

    // item on picker selected
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        String city = parent.getItemAtPosition(pos).toString();
        TextView temperaturetv = (TextView) findViewById(R.id.temperatureTextView);
        ImageView conditionsiv = (ImageView) findViewById(R.id.conditionsImageView);

        // update UI i.e. temperature and conditions
        for (Weather w : weatherList) {
            if (w.getCity().equalsIgnoreCase(city)) {
                temperaturetv.setText(w.getDegrees() + " Celsius");

                if (w.getCondition() == WeatherCondition.SUNNY) {
                    conditionsiv.setImageResource(R.drawable.sunny);
                } else if (w.getCondition() == WeatherCondition.CLOUDY) {
                    conditionsiv.setImageResource(R.drawable.cloudy);
                } else {
                    conditionsiv.setImageResource(R.drawable.rain);
                }
            }
        }
    }

    public void onNothingSelected(AdapterView<?> parent)
    {
        // Another interface callback
    }
}
