package com.core.reviews.repositories.impl;

import com.core.reviews.models.MovieModel;
import com.core.reviews.repositories.DefaultMoviesRepository;
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
public class DefaultMoviesRepositoryImpl implements DefaultMoviesRepository {
    public static final String ID_FIELD = "_id";
    public static final String LASTUPDATED_FIELD = "lastupdated";
    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter mongoConverter;
    public static final String RELEASED_DATE_FIELD = "releasedDate";
    public static final String[] SEARCHABLE_FIELDS = {"title","year","genre","cast","fullplot","directors","releasedDate","cast","rated"};

    @Override
    public List<MovieModel> findMovies(String query, Long resultCount) {
        AggregateIterable<Document> result = getMoviesCollection().aggregate(Arrays.asList(new Document(MFlixUtilities.SEARCH_KEYWORD,
                        new Document(MFlixUtilities.INDEX_KEYWORD, MFlixUtilities.MOVIES_INDEX).append(MFlixUtilities.TEXT_KEYWORD,
                                new Document(MFlixUtilities.QUERY_KEYWORD, query).append(MFlixUtilities.PATH_KEYWORD, Arrays.asList(SEARCHABLE_FIELDS)))),
                MFlixUtilities.sortByDateStage(RELEASED_DATE_FIELD), new Document(MFlixUtilities.LIMIT_KEYWORD, resultCount), projectStage()));

        return convertRecordsToList(result);
    }

    private MongoCollection<Document> getMoviesCollection() {
        return mongoClient.getDatabase(MFlixUtilities.dataBaseName).getCollection(MFlixUtilities.MOVIES_COLLECTION);
    }

    private List<MovieModel> convertRecordsToList(AggregateIterable<Document> result) {
        List<MovieModel> movies = new ArrayList<>();
        result.forEach(doc -> movies.add(mongoConverter.read(MovieModel.class, doc)));
        return movies;
    }

    private Document projectStage() {
        return new Document(MFlixUtilities.PROJECT_KEYWORD, new Document(ID_FIELD, 0L).append(LASTUPDATED_FIELD, 0L));
    }
}
