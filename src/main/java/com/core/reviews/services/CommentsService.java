package com.core.reviews.services;

import com.core.reviews.beans.CommentData;
import com.core.reviews.models.CommentModel;

import java.util.List;

public interface CommentsService {
    CommentModel findCommentById(String id);
    List<CommentData> findAllCommentsForQuery(String query, String count);
    CommentModel postCommentForMovie(CommentData commentData);
    List<CommentData> findCommentsForMovie(String movieId);
}
