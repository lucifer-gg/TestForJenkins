package com.example.oasis.po;

public class Spot {
    Integer spotid;
    String spotname;
    Integer spotnum;

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

    public Integer getSpotnum() {
        return spotnum;
    }

    public void setSpotnum(Integer spotnum) {
        this.spotnum = spotnum;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "spotid=" + spotid +
                ", spotname='" + spotname + '\'' +
                ", spotnum=" + spotnum +
                '}';
    }

}
