package com.core.reviews.utils;

import org.bson.Document;

public class MFlixUtilities {
    public static String dataBaseName = "sample_mflix";
    public static String COMMENTS_COLLECTION = "comments";
    public static String MOVIES_COLLECTION = "movies";
    public static final String INDEX_KEYWORD = "index";
    public static final String COMMENTS_INDEX = "comments_idx";
    public static final String MOVIES_INDEX = "movie_idx";
    public static final String SEARCH_KEYWORD = "$search";
    public static final String TEXT_KEYWORD = "text";
    public static final String QUERY_KEYWORD = "query";
    public static final String PATH_KEYWORD = "path";
    public static final String LIMIT_KEYWORD = "$limit";
    public static final String PROJECT_KEYWORD = "$project";
    public static final String FOREIGN_FIELD_KEYWORD = "foreignField";
    public static final String LOCAL_FIELD_KEYWORD = "localField";
    public static final String FROM_KEYWORD = "from";
    public static final String $_MATCH_KEYWORD = "$match";
    public static final String RESULT_KEYWORD = "result";
    public static final String AS_KEYWORD = "as";
    public static final String $_LOOKUP_KEYWORD = "$lookup";
    public static Document sortByDateStage(String fieldName) {
        return new Document("$sort", new Document(fieldName, -1L));
    }
}
