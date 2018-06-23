package com.example.gagafree.myapplication75000;

/**
 * Created by evismar on 20/10/2017.
 */

public class Warning {

    double latitude;
    double longitude;
    int signalstrength;
    String operator;
    String date;



    public Warning() {

    }




    public Warning(double latitude, double longitude, int signalstrength, String operator ,String date) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.signalstrength = signalstrength;
        this.operator = operator;
        this.date = date;



    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getSignalstrength() {
        return signalstrength;
    }

    public void setSignalstrength(int signalstrength) {
        this.signalstrength = signalstrength;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}



