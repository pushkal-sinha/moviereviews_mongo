package com.core.reviews.repositories;

import com.core.reviews.models.CommentModel;

import java.util.List;

public interface DefaultCommentsRepository {
    List<CommentModel> findComments(String query, long resultCount);
    List<CommentModel> findCommentsForMovie(Object movieId);
}
