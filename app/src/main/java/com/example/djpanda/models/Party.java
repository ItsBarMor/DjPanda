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
    public final String djName;
    public final int djId;

    public final String genres;

    public final double priceMen;
    public final double priceWomen;

    public final double earlyPriceMen;
    public final double earlyPriceWomen;
    public final String earlySaleValidUntilDate; //when the early sale ends

    public final int ageLimit;
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
            String djName,
            int djId,
            String genres,
            double priceMen,
            double priceWomen,
            double earlyPriceMen,
            double earlyPriceWomen,
            String earlySaleValidUntilDate,
            int ageLimit,
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
        this.djName = djName;
        this.djId = djId;
        this.genres = genres;
        this.priceMen = priceMen;
        this.priceWomen = priceWomen;
        this.earlyPriceMen = earlyPriceMen;
        this.earlyPriceWomen = earlyPriceWomen;
        this.earlySaleValidUntilDate = earlySaleValidUntilDate;
        this.ageLimit = ageLimit;
        this.description = description;
    }
}
