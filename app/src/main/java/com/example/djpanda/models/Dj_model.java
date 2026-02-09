package com.example.djpanda.models;

public class Dj_model {
    public final int id;
    public final String name;
    public final int imageResId;
    public final String genres;
    public final String locations; // can be several locations such as Tel Aviv and Holon and Rishon ect
    public final String bio;
    public final double rating; // the ratings are between 0.0 to 5.0
    public final int reviewsCount;
    public final Review review;
    public double latitude;
    public double longitude;
    public float distanceFromUser;


    public Dj_model(
            int id,
            String name,
            int imageResId,
            String genres,
            String locations,
            String bio,
            double rating,
            int reviewsCount,
            Review review,
            double latitude,
            double longitude,
            float distanceFromUser

    ) {
        this.id = id;
        this.name = name;
        this.imageResId = imageResId;
        this.genres = genres;
        this.locations = locations;
        this.bio = bio;
        this.rating = rating;
        this.reviewsCount = reviewsCount;
        this.review=review;
        this.latitude=latitude;
        this.longitude=longitude;
        this.distanceFromUser=distanceFromUser;
    }
}
