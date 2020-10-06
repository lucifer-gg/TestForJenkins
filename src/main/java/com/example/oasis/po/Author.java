package com.example.oasis.po;

import java.util.Objects;

public class Author {

    private Integer author_id;

    private String author_name;

    private String author_affiliations;

    private String author_keywords;

    private String Funding_Information;

    private Integer Reference_Count;

    private Integer papernum;

    public Integer getPapernum() {
        return papernum;
    }

    public void setPapernum(Integer papernum) {
        this.papernum = papernum;
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
        return "Author{" +
                "author_id=" + author_id +
                ", author_name='" + author_name + '\'' +
                ", author_affiliations='" + author_affiliations + '\'' +
                ", author_keywords='" + author_keywords + '\'' +
                ", Funding_information='" + Funding_Information + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(getAuthor_name(), author.getAuthor_name()) &&
                Objects.equals(getAuthor_affiliations(), author.getAuthor_affiliations());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthor_name(), getAuthor_affiliations());
    }
}
