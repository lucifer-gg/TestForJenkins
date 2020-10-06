package com.example.oasis.vo;


import java.util.List;

public class PaperRank {
    private String title;
    private int citation_counts;
    private List<String> authors;
    private int paperId;
    private double hotNum;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCitation_counts() {
        return citation_counts;
    }

    public void setCitation_counts(int citation_counts) {
        this.citation_counts = citation_counts;
    }


    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public double getHotNum() {
        return hotNum;
    }

    public void setHotNum(double hotNum) {
        this.hotNum = hotNum;
    }
}
