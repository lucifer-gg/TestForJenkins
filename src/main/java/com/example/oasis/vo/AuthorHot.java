package com.example.oasis.vo;

public class AuthorHot {
    private  int authorId;
    private  String author;
    private String domain;
    private float hotNum;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public float getHotNum() {
        return hotNum;
    }

    public void setHotNum(float hotNum) {
        this.hotNum = hotNum;
    }
}
