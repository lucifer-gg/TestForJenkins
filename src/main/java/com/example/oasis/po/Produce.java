package com.example.oasis.po;

import java.util.Objects;

public class Produce {

    private Integer create_id;

    private Integer paper_id;

    private Integer author_id;

    private Paper paper;

    private Author author;

    public Integer getCreate_id() {
        return create_id;
    }

    public void setCreate_id(Integer create_id) {
        this.create_id = create_id;
    }

    public Integer getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(Integer paper_id) {
        this.paper_id = paper_id;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Produce{" +
                "create_id=" + create_id +
                ", paper_id=" + paper_id +
                ", author_id=" + author_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produce produce = (Produce) o;
        return Objects.equals(getCreate_id(), produce.getCreate_id()) &&
                Objects.equals(getPaper_id(), produce.getPaper_id()) &&
                Objects.equals(getAuthor_id(), produce.getAuthor_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCreate_id(), getPaper_id(), getAuthor_id());
    }
}
