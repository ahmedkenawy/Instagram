package com.ahmedkenawy.instagram.Model;

public class Comment {

    private String comment;
    private String publisherid;
    private String time;
    private String date;

    public Comment() {
    }

    public Comment(String comment, String publisherid, String time, String date) {
        this.comment = comment;
        this.publisherid = publisherid;
        this.time = time;
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(String publisherid) {
        this.publisherid = publisherid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
