package com.core.reviews.services.impl;

import com.core.reviews.beans.CommentData;
import com.core.reviews.converters.CommentDataConverter;
import com.core.reviews.converters.CommentModelConverter;
import com.core.reviews.models.CommentModel;
import com.core.reviews.repositories.CommentsRepository;
import com.core.reviews.repositories.DefaultCommentsRepository;
import com.core.reviews.services.CommentsService;
import com.core.reviews.services.MoviesService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    CommentsRepository commentsRepository;
    @Autowired
    DefaultCommentsRepository defaultCommentsRepository;
    @Autowired
    CommentDataConverter commentDataConverter;
    @Autowired
    MoviesService moviesService;
    @Autowired
    CommentModelConverter commentModelConverter;

    @Override
    public CommentModel findCommentById(String id) {
        if(!StringUtils.isEmpty(id)){
            Optional<CommentModel> commentOptional = commentsRepository.findById(id);
            if(commentOptional.isPresent())
                return commentOptional.get();
        }
        return null;
    }

    @Override
    public List<CommentData> findAllCommentsForQuery(String query, String count) {
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
        List<CommentModel> commentModelList = defaultCommentsRepository.findComments(query,resultCount);
        List<CommentData> commentDataList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(commentModelList)){
            commentModelList.forEach(commentModel -> {
                CommentData commentData = new CommentData();
                commentDataConverter.convert(commentModel,commentData);
                commentDataList.add(commentData);
            });
            return commentDataList;
        }
        return null;
    }

    @Override
    public CommentModel postCommentForMovie(CommentData commentData) {
        if(moviesService.isMoiveExists(commentData)){
            CommentModel commentModel = new CommentModel();
            commentModelConverter.convert(commentData,commentModel);
            return commentsRepository.save(commentModel);
        }
        return null;
    }

    @Override
    public List<CommentData> findCommentsForMovie(String movieId) {
        if(!StringUtils.isEmpty(movieId)){
            List<CommentModel> commentModels = defaultCommentsRepository.findCommentsForMovie(new ObjectId(movieId));
            List<CommentData> commentDataList = new ArrayList<>();
            commentModels.forEach(commentModel -> {
                CommentData commentData = new CommentData();
                commentDataConverter.convert(commentModel,commentData);
                commentData.setMovie_id(movieId);
                commentDataList.add(commentData);
            });
            return commentDataList;
        }
        return null;
    }
}
