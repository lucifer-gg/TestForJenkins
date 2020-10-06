package com.example.oasis.vo;

import com.example.oasis.po.Paper;

import java.util.List;

public class RankPaper {
    private List<Paper> paperList;

    public RankPaper(List<Paper> paperList){
        this.paperList=paperList;
    }

    public List<Paper> getPaperList() {
        return paperList;
    }

    public void setPaperList(List<Paper> paperList) {
        this.paperList = paperList;
    }
}
