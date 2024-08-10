package com.core.reviews.models;

public class AwardsModel {
    private Integer wins;
    private Integer nominations;
    private String text;
    public AwardsModel() {
    }

    @Override
    public String toString() {
        return "Awards{" +
                "wins=" + wins +
                ", nominations=" + nominations +
                ", text='" + text + '\'' +
                '}';
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getNominations() {
        return nominations;
    }

    public void setNominations(Integer nominations) {
        this.nominations = nominations;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
