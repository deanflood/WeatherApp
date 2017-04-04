package models;

/**
 * Created by ADMINIBM on 01/04/2017.
 */

public class Weather {
    public String getCity() {
        return city;
    }

    public double getDegrees() {
        return degrees;
    }

    public WeatherCondition getCondition() {
        return condition;
    }

    private String city;
    private double degrees;
    private  WeatherCondition condition;

    public Weather(String city, double degrees, WeatherCondition condition){
        this.city = city;
        this.degrees = degrees;
        this.condition = condition;
    }


}
