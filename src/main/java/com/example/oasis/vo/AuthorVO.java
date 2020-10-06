package com.example.oasis.vo;

import com.example.oasis.po.Author;

public class AuthorVO {
    private Integer author_id;

    private String author_name;

    private String author_affiliations;

    private String author_keywords;

    private String Funding_Information;

    private Integer Reference_Count;

    public AuthorVO(Author author){
        this.author_affiliations=author.getAuthor_affiliations();
        this.author_id=author.getAuthor_id();
        this.author_keywords=author.getAuthor_keywords();
        this.author_name=author.getAuthor_name();
    }


    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_affiliations() {
        return author_affiliations;
    }

    public void setAuthor_affiliations(String author_affiliations) {
        this.author_affiliations = author_affiliations;
    }

    public String getAuthor_keywords() {
        return author_keywords;
    }

    public void setAuthor_keywords(String author_keywords) {
        this.author_keywords = author_keywords;
    }

    public String getFunding_Information() {
        return Funding_Information;
    }

    public void setFunding_Information(String funding_Information) {
        Funding_Information = funding_Information;
    }

    public Integer getReference_Count() {
        return Reference_Count;
    }

    public void setReference_Count(Integer reference_Count) {
        Reference_Count = reference_Count;
    }

    @Override
    public String toString() {
        return "AuthorVO{" +
                "author_id=" + author_id +
                ", author_name='" + author_name + '\'' +
                ", author_affiliations='" + author_affiliations + '\'' +
                ", author_keywords='" + author_keywords + '\'' +
                ", Funding_Information='" + Funding_Information + '\'' +
                '}';
    }
}
