package com.example.individualproject.Model;

public class MovieReviewModel {

    String content,moviename,username;

    public MovieReviewModel(){}

    public MovieReviewModel(String content, String moviename, String username) {
        this.content = content;
        this.moviename = moviename;
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
