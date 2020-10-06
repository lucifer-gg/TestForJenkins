package com.example.oasis.vo;

import com.example.oasis.po.AuthorSpot;


public class AuthorSpotVO {

    Integer spotnum;

    String author;

    Integer authorid;

    public AuthorSpotVO(AuthorSpot authorSpot){
        this.spotnum=authorSpot.getSpotnum();
        this.author=authorSpot.getAuthor();
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public Integer getSpotnum() {
        return spotnum;
    }

    public void setSpotnum(Integer spotnum) {
        this.spotnum = spotnum;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "AuthorSpotVO{" +
                "spotnum=" + spotnum +
                ", author='" + author + '\'' +
                '}';
    }
}
