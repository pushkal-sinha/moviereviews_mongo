package com.core.reviews.converters;

import com.core.reviews.beans.CommentData;
import com.core.reviews.models.CommentModel;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CommentDataConverter implements GenericConverter<CommentModel,CommentData>{
    @Override
    public void convert(CommentModel source, CommentData target) {
        if(Objects.nonNull(source)){
            if(Objects.nonNull(source.getName())){
                target.setUserName(source.getName());
            }
            if(Objects.nonNull(source.getEmail())){
                target.setUserEmail(source.getEmail());
            }
            if(Objects.nonNull(source.getDate())){
                target.setCommentDate(source.getDate());
            }
            if(Objects.nonNull(source.getText())){
                target.setCommentText(source.getText());
            }
        }
    }
}
