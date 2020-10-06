package com.example.oasis.vo;

import com.example.oasis.po.Spot;

public class SpotVO {
//    Integer spotid;
    String spotname;
    Integer spotnum;

    public SpotVO(Spot spot){
        this.spotname=spot.getSpotname();
        this.spotnum=spot.getSpotnum();
    }

//    public Integer getSpotid() {
//        return spotid;
//    }
//
//    public void setSpotid(Integer spotid) {
//        this.spotid = spotid;
//    }

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
        return "SpotVO{" +
                "spotname='" + spotname + '\'' +
                ", spotnum=" + spotnum +
                '}';
    }
}
