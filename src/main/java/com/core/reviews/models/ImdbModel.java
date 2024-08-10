package com.core.reviews.models;

public class ImdbModel {
    private Integer rating;
    private Integer votes;

    @Override
    public String toString() {
        return "Imdb{" +
                "rating=" + rating +
                ", votes=" + votes +
                ", id='" + id + '\'' +
                '}';
    }

    public ImdbModel() {
    }

    private String id;
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
