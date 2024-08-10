package com.core.reviews.converters;

import com.core.reviews.beans.CommentData;
import com.core.reviews.models.CommentModel;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class CommentModelConverter implements GenericConverter<CommentData,CommentModel>{
    @Override
    public void convert(CommentData source, CommentModel target) {
        if(Objects.nonNull(source)){
            if(Objects.nonNull(source.getMovie_id())){
                target.setMovie_id(new ObjectId(source.getMovie_id()));
            }
            if(Objects.nonNull(source.getUserEmail())){
                target.setEmail(source.getUserEmail());
            }
            if(Objects.nonNull(source.getCommentDate())){
                target.setDate(source.getCommentDate());
            }
            else{
                target.setDate(new Date());
            }
            if(Objects.nonNull(source.getCommentText())){
                target.setText(source.getCommentText());
            }
            if(Objects.nonNull(source.getUserName())){
                target.setName(source.getUserName());
            }
        }
    }
}
