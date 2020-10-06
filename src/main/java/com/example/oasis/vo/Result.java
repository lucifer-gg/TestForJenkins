package com.example.oasis.vo;

import java.util.List;

public class Result {
    private int total;
    private List<SearchResult> searchResult;
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


    public List<SearchResult> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<SearchResult> searchResult) {
        this.searchResult = searchResult;
    }




}
