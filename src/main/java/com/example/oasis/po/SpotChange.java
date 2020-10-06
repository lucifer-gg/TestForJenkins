package com.example.oasis.po;

import org.springframework.data.relational.core.sql.In;

public class SpotChange {
    Integer spotnum;

    Integer year;

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
}
