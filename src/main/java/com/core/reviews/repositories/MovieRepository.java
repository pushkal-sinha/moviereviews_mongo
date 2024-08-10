package com.core.reviews.repositories;

import com.core.reviews.models.MovieModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface MovieRepository extends MongoRepository<MovieModel,String> {
}
