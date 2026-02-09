package com.example.djpanda.models;

public class NearbyDj_model {

    public int id;
    public int imageRes;
    public String name;
    public String distance;
    public double latitude;
    public double longitude;
    public float distanceFromUser;


    public NearbyDj_model(int id, int imageRes, String name, String distance , double latitude, double longitude) {
        this.id = id;
        this.imageRes = imageRes;
        this.name = name;
        this.distance = distance;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
