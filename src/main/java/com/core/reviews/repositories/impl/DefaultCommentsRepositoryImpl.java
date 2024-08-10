package com.core.reviews.repositories.impl;

import com.core.reviews.models.CommentModel;
import com.core.reviews.repositories.DefaultCommentsRepository;
import com.core.reviews.utils.MFlixUtilities;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DefaultCommentsRepositoryImpl implements DefaultCommentsRepository {
    public static final String ID_FIELD = "_id";
    public static final String MOVIE_ID_FIELD = "movie_id";
    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter mongoConverter;
    public static final String DATE_FIELD = "date";
    public static final String[] SEARCHABLE_FIELDS = {"name", "text", "email", "date"};
    @Override
    public List<CommentModel> findComments(String query, long resultCount) {


        AggregateIterable<Document> result = getCommentsCollection().aggregate(Arrays.asList(new Document(MFlixUtilities.SEARCH_KEYWORD,
                        new Document(MFlixUtilities.INDEX_KEYWORD, MFlixUtilities.COMMENTS_INDEX).append(MFlixUtilities.TEXT_KEYWORD,
                                new Document(MFlixUtilities.QUERY_KEYWORD, query).append(MFlixUtilities.PATH_KEYWORD, Arrays.asList(SEARCHABLE_FIELDS)))),
                MFlixUtilities.sortByDateStage(DATE_FIELD), new Document(MFlixUtilities.LIMIT_KEYWORD, resultCount), projectStage()));

        return convertRecordsToList(result);
    }

    @Override
    public List<CommentModel> findCommentsForMovie(Object movieId){
        AggregateIterable<Document> result = getCommentsCollection().aggregate(Arrays.asList(new Document(MFlixUtilities.$_LOOKUP_KEYWORD,
                        new Document(MFlixUtilities.FROM_KEYWORD, MFlixUtilities.MOVIES_COLLECTION)
                                .append(MFlixUtilities.LOCAL_FIELD_KEYWORD, MOVIE_ID_FIELD)
                                .append(MFlixUtilities.FOREIGN_FIELD_KEYWORD, ID_FIELD)
                                .append(MFlixUtilities.AS_KEYWORD, MFlixUtilities.RESULT_KEYWORD)),
                new Document(MFlixUtilities.$_MATCH_KEYWORD,
                        new Document(MOVIE_ID_FIELD,movieId)),projectStage()));

        return convertRecordsToList(result);
    }

    private MongoCollection<Document> getCommentsCollection() {
        return mongoClient.getDatabase(MFlixUtilities.dataBaseName).getCollection(MFlixUtilities.COMMENTS_COLLECTION);
    }

    private List<CommentModel> convertRecordsToList(AggregateIterable<Document> result) {
        List<CommentModel> comments = new ArrayList<>();
        result.forEach(doc -> comments.add(mongoConverter.read(CommentModel.class,doc)));
        return comments;
    }

    private Document projectStage() {
        return new Document("$project", new Document("_id", 0L).append("movie_id", 0L));
    }
}
