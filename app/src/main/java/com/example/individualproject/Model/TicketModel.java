package com.example.individualproject.Model;

public class TicketModel {

    String fomate,imageURL,moviename,time;
    int quantity,totalprice;

    public TicketModel(){}

    public TicketModel(String fomate, String imageURL, String moviename, String time, int quantity, int totalprice) {
        this.fomate = fomate;
        this.imageURL = imageURL;
        this.moviename = moviename;
        this.time = time;
        this.quantity = quantity;
        this.totalprice = totalprice;
    }

    public String getFomate() {
        return fomate;
    }

    public void setFomate(String fomate) {
        this.fomate = fomate;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
}
