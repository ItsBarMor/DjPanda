package com.example.djpanda.models;

public class Party {
    public final int id;
    public final String name;
    public final String category;
    public final int imageResId;
    public final String date;
    public final String time;
    public final String locationName;
    public final String city;
    public final int djId;
    public final int price;
    public final String description;

    public Party(
            int id,
            String name,
            String category,
            int imageResId,
            String date,
            String time,
            String locationName,
            String city,
            int djId,
            int price,
            String description
    ) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.imageResId = imageResId;
        this.date = date;
        this.time = time;
        this.locationName = locationName;
        this.city = city;
        this.djId = djId;
        this.price = price;
        this.description = description;
    }
}
