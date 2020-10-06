package com.example.oasis.vo;

import com.example.oasis.po.Author;

import java.util.List;

public class RankAuthor {
    private List<Author> authorList;
    public RankAuthor(List<Author> authorList){
        this.authorList=authorList;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }
}
