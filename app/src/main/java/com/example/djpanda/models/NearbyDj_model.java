package com.example.djpanda.models;

public class NearbyDj_model {

    public int id;
    public int imageRes;
    public String name;
    public String distance;

    public NearbyDj_model(int id, int imageRes, String name, String distance) {
        this.id = id;
        this.imageRes = imageRes;
        this.name = name;
        this.distance = distance;
    }
}
