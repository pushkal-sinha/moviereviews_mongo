package com.core.reviews.repositories;

import com.core.reviews.models.CommentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface CommentsRepository extends MongoRepository<CommentModel,String> {
}
