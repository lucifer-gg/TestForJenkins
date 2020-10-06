package com.example.oasis.po;

public class SpotItem {
    Integer spotid;
    String spotname;
    Integer year;
    String author;
    String organization;


    public Integer getSpotid() {
        return spotid;
    }

    public void setSpotid(Integer spotid) {
        this.spotid = spotid;
    }

    public String getSpotname() {
        return spotname;
    }

    public void setSpotname(String spotname) {
        this.spotname = spotname;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "SpotItem{" +
                "spotname='" + spotname + '\'' +
                ", year=" + year +
                ", author='" + author + '\'' +
                ", organization='" + organization + '\'' +
                '}';
    }
}
