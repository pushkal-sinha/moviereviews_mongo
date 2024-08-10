package com.core.reviews.models;

import org.springframework.data.mongodb.core.mapping.Field;

public class ReviewerModel {
    private Double rating;
    @Field(value = "numReviews")
    private Integer numberOfReviews;
    private Integer meter;

    public ReviewerModel() {
    }

    @Override
    public String toString() {
        return "Viewer{" +
                "rating=" + rating +
                ", numberOfReviews=" + numberOfReviews +
                ", Meter=" + meter +
                '}';
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(Integer numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public Integer getMeter() {
        return meter;
    }

    public void setMeter(Integer meter) {
        this.meter = meter;
    }
}
