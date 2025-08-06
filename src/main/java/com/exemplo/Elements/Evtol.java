//Objeto Evtol

package com.exemplo.Elements; 

public class Evtol {

    public String id;
    public double latitude;
    public double longitude;
    public int battery;

    public Evtol(String id, double latitude, double longitude, int battery){
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.battery = battery;
    }

    public String getId(){ return this.id; }
    public double getLatitude(){ return this.latitude; }
    public double getLongitude(){ return this.longitude; }
    public int getBattery(){  return this.battery; }
}
