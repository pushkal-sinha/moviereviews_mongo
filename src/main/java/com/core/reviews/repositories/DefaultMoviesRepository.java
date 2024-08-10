package com.core.reviews.repositories;

import com.core.reviews.models.MovieModel;

import java.util.List;

public interface DefaultMoviesRepository{
    List<MovieModel> findMovies(String query, Long resultCount);
}
