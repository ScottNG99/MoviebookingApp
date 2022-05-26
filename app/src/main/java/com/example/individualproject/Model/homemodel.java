package com.example.individualproject.Model;

public class homemodel {
    String MovieID;
    String moviename,score,movietime,imageURL,introduce;
    int price;

    public homemodel(){

    }

    public homemodel(String movieID, String moviename, String score, String movietime, String imageURL, String introduce, int price) {
        MovieID = movieID;
        this.moviename = moviename;
        this.score = score;
        this.movietime = movietime;
        this.imageURL = imageURL;
        this.introduce = introduce;
        this.price = price;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getMovietime() {
        return movietime;
    }

    public void setMovietime(String movietime) {
        this.movietime = movietime;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMovieID() {
        return MovieID;
    }

    public void setMovieID(String movieID) {
        MovieID = movieID;
    }


    @Override
    public String toString() {
        return "homemodel{" +
                "MovieID='" + MovieID + '\'' +
                ", moviename='" + moviename + '\'' +
                ", score='" + score + '\'' +
                ", movietime='" + movietime + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", introduce='" + introduce + '\'' +
                ", price=" + price +
                '}';
    }
}
