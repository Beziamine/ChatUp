package com.example.gagafree.myapplication75000;

/**
 * Created by evismar on 20/10/2017.
 */

public class LocationData {

    double latitude;
    double longitude;
    int signalstrength;
    int rssi;
    int ecio;
    int snr;
    int ber;
    String date;



    public LocationData() {

    }




    public LocationData(double latitude, double longitude, int signalstrength, int rssi,int ecio,int snr, int ber, String date) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.signalstrength = signalstrength;
        this.rssi = rssi;
        this.ecio = ecio;
        this.snr = snr;
        this.ber = ber;
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

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public int getEcio() {
        return ecio;
    }

    public void setEcio(int ecio) {
        this.ecio = ecio;
    }

    public int getSnr() {
        return snr;
    }

    public void setSnr(int snr) {
        this.snr = snr;
    }

    public int getBer() {
        return ber;
    }

    public void setBer(int ber) {
        this.ber = ber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}



