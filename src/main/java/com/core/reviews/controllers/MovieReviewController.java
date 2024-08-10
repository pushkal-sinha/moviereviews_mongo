package com.core.reviews.controllers;

import com.core.reviews.beans.CommentData;
import com.core.reviews.models.CommentModel;
import com.core.reviews.models.MovieModel;
import com.core.reviews.services.CommentsService;
import com.core.reviews.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class MovieReviewController {
    @Autowired
    CommentsService commentsService;
    @Autowired
    MoviesService moviesService;
    @Value("${app.version}")
    public String version;
    @GetMapping(value = "/hello-ui")
    public String testApi(){
        return "Hello, v" + version + " is Live!";
    }

    @GetMapping(value = "/findCommentById/{commentId}")
    public CommentModel getAllComments(@PathVariable String commentId){
        return commentsService.findCommentById(commentId);
    }

    @GetMapping(value = "/findMovieById/{movieId}")
    public MovieModel getAllMovies(@PathVariable String movieId){
        return moviesService.findMovieById(movieId);
    }

    @GetMapping(value = "/getComments")
    public List<CommentData> getCommentsForQuery(@RequestParam String query, @RequestParam(required = false) String count){
        return commentsService.findAllCommentsForQuery(query,count);
    }
    @GetMapping(value = "/getMovies")
    public List<MovieModel> getMoviesForQuery(@RequestParam String query, @RequestParam(required = false) String count){
        return moviesService.findMovies(query,count);
    }

    @PostMapping(value = "/postComment")
    public String postCommentForMovie(@RequestBody CommentData commentData){
        CommentModel comment = commentsService.postCommentForMovie(commentData);
        if(Objects.nonNull(comment)){
            return "Comment Posted For Movie";
        }
        else{
            return "Could Not Post comment.";
        }
    }
    @GetMapping(value = "/getCommentForMovie")
    public List<CommentData> getCommentsForQuery(@RequestParam String movieId){
        return commentsService.findCommentsForMovie(movieId);
    }
}
