package com.example.oasis.vo;


import com.example.oasis.po.SpotChange;

public class SpotChangeVO {
    Integer spotnum;

    Integer year;

    public SpotChangeVO(SpotChange spotChange){
        this.spotnum=spotChange.getSpotnum();
        this.year=spotChange.getYear();
    }

    public Integer getSpotnum() {
        return spotnum;
    }

    public void setSpotnum(Integer spotnum) {
        this.spotnum = spotnum;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "SpotChangeVO{" +
                "spotnum=" + spotnum +
                ", year=" + year +
                '}';
    }
}
