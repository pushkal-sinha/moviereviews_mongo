package com.core.reviews.services;

import com.core.reviews.beans.CommentData;
import com.core.reviews.models.MovieModel;

import java.util.List;

public interface MoviesService {
    MovieModel findMovieById(String id);
    List<MovieModel> findMovies(String query, String count);

    Boolean isMoiveExists(CommentData commentData);
}
