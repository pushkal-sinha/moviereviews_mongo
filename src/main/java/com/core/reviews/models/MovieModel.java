package com.core.reviews.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Arrays;
import java.util.Date;

@Document(collection = "movies")
@TypeAlias("Movies")
public class MovieModel {
    @Id
    private String _id;
    private String plot;
    private String[] genres;
    @Field(value = "poster")
    private String posterUrl;
    private Integer runtime;
    private String[] cast;
    private String title;
    @Field(value = "fullplot")
    private String fullPlot;
    private String[] languages;
    private String[] directors;
    private String rated;
    private String year;
    private String[] countries;
    private String type;
    private Integer num_mflix_comments;
    private AwardsModel awards;
    private ImdbModel imdb;
    private TomatoesModel tomatoes;

    @Field(value = "released")
    private Date releasedDate;

    @Field(value = "lastupdated")
    private String lastUpdatedDate;
    public MovieModel() {
    }
    @Override
    public String toString() {
        return "Movie{" +
                "movie_id='" + _id + '\'' +
                ", plot='" + plot + '\'' +
                ", genres=" + Arrays.toString(genres) +
                ", posterUrl='" + posterUrl + '\'' +
                ", runtime=" + runtime +
                ", cast=" + Arrays.toString(cast) +
                ", title='" + title + '\'' +
                ", fullPlot='" + fullPlot + '\'' +
                ", languages=" + Arrays.toString(languages) +
                ", directors=" + Arrays.toString(directors) +
                ", rated='" + rated + '\'' +
                ", year=" + year +
                ", countries=" + Arrays.toString(countries) +
                ", type='" + type + '\'' +
                ", num_mflix_comments=" + num_mflix_comments +
                ", awards=" + awards +
                ", imdb=" + imdb +
                ", releasedDate=" + releasedDate +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", tomatoes=" + tomatoes +
                '}';
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String[] getCast() {
        return cast;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullPlot() {
        return fullPlot;
    }

    public void setFullPlot(String fullPlot) {
        this.fullPlot = fullPlot;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String[] getDirectors() {
        return directors;
    }

    public void setDirectors(String[] directors) {
        this.directors = directors;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String[] getCountries() {
        return countries;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNum_mflix_comments() {
        return num_mflix_comments;
    }

    public void setNum_mflix_comments(Integer num_mflix_comments) {
        this.num_mflix_comments = num_mflix_comments;
    }

    public AwardsModel getAwards() {
        return awards;
    }
    public void setAwards(AwardsModel awards) {
        this.awards = awards;
    }

    public ImdbModel getImdb() {
        return imdb;
    }

    public void setImdb(ImdbModel imdb) {
        this.imdb = imdb;
    }

    public Date getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public TomatoesModel getTomatoes() {
        return tomatoes;
    }

    public void setTomatoes(TomatoesModel tomatoes) {
        this.tomatoes = tomatoes;
    }
}
