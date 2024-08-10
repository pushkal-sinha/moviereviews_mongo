package com.core.reviews.services.impl;

import com.core.reviews.beans.CommentData;
import com.core.reviews.models.CommentModel;
import com.core.reviews.models.MovieModel;
import com.core.reviews.repositories.DefaultMoviesRepository;
import com.core.reviews.repositories.MovieRepository;
import com.core.reviews.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class MoviesServiceImpl implements MoviesService {
    @Autowired
    DefaultMoviesRepository defaultMoviesRepository;
    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieModel findMovieById(String id) {
        if(!StringUtils.isEmpty(id)){
            Optional<MovieModel> moviesOptional = movieRepository.findById(id);
            if(moviesOptional.isPresent())
                return moviesOptional.get();
        }
        return null;
    }

    @Override
    public List<MovieModel> findMovies(String query, String count) {
        long resultCount;
        try {
            if (!StringUtils.isEmpty(count)) {
                resultCount = Long.parseLong(count);
            } else {
                resultCount = Long.parseLong("5");
            }
        }
        catch (Exception e){
            resultCount = Long.parseLong("5");
        }
        return defaultMoviesRepository.findMovies(query,resultCount);
    }

    @Override
    public Boolean isMoiveExists(CommentData commentData) {
        return movieRepository.existsById(commentData.getMovie_id());
    }
}
