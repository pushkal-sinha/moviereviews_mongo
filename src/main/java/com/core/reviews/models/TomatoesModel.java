package com.core.reviews.models;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

public class TomatoesModel {
    private ReviewerModel viewer;
    private Integer fresh;
    private ReviewerModel critic;
    private Integer rotten;
    @Field(value = "lastupdated")
    private Date lastUpdatedDate;

    public TomatoesModel() {
    }

    @Override
    public String toString() {
        return "Tomatoes{" +
                "reviewer=" + viewer +
                ", fresh=" + fresh +
                ", critic=" + critic +
                ", rotten=" + rotten +
                ", lastUpdatedDate=" + lastUpdatedDate +
                '}';
    }

    public ReviewerModel getViewer() {
        return viewer;
    }

    public void setViewer(ReviewerModel viewer) {
        this.viewer = viewer;
    }

    public Integer getFresh() {
        return fresh;
    }

    public void setFresh(Integer fresh) {
        this.fresh = fresh;
    }

    public ReviewerModel getCritic() {
        return critic;
    }

    public void setCritic(ReviewerModel critic) {
        this.critic = critic;
    }

    public Integer getRotten() {
        return rotten;
    }

    public void setRotten(Integer rotten) {
        this.rotten = rotten;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
}
