package com.example.individualproject.Model;

public class Moviemodel {
    //set 所需要的data，方便get firebase data
    String MovieID;
    String moviename,movietime,imageURL,introduce,love,cry,score,time1,time2,time3,fomate1,fomate2,fomate3;
    int price,quantity;

    public Moviemodel(){}


    public Moviemodel(String movieID, String moviename, String movietime, String imageURL, String introduce, String love, String cry, String score, String time1, String time2, String time3, String fomate1, String fomate2, String fomate3, int price, int quantity) {
        MovieID = movieID;
        this.moviename = moviename;
        this.movietime = movietime;
        this.imageURL = imageURL;
        this.introduce = introduce;
        this.love = love;
        this.cry = cry;
        this.score = score;
        this.time1 = time1;
        this.time2 = time2;
        this.time3 = time3;
        this.fomate1 = fomate1;
        this.fomate2 = fomate2;
        this.fomate3 = fomate3;
        this.price = price;
        this.quantity = quantity;
    }

    public String getMovieID() {
        return MovieID;
    }

    public void setMovieID(String movieID) {
        MovieID = movieID;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
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

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getCry() {
        return cry;
    }

    public void setCry(String cry) {
        this.cry = cry;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getTime3() {
        return time3;
    }

    public void setTime3(String time3) {
        this.time3 = time3;
    }

    public String getFomate1() {
        return fomate1;
    }

    public void setFomate1(String fomate1) {
        this.fomate1 = fomate1;
    }

    public String getFomate2() {
        return fomate2;
    }

    public void setFomate2(String fomate2) {
        this.fomate2 = fomate2;
    }

    public String getFomate3() {
        return fomate3;
    }

    public void setFomate3(String fomate3) {
        this.fomate3 = fomate3;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Moviemodel{" +
                "MovieID='" + MovieID + '\'' +
                ", moviename='" + moviename + '\'' +
                ", movietime='" + movietime + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", introduce='" + introduce + '\'' +
                ", love='" + love + '\'' +
                ", cry='" + cry + '\'' +
                ", score='" + score + '\'' +
                ", time1='" + time1 + '\'' +
                ", time2='" + time2 + '\'' +
                ", time3='" + time3 + '\'' +
                ", fomate1='" + fomate1 + '\'' +
                ", fomate2='" + fomate2 + '\'' +
                ", fomate3='" + fomate3 + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
