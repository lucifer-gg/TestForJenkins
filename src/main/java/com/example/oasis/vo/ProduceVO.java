package com.example.oasis.vo;

import com.example.oasis.po.Author;
import com.example.oasis.po.Paper;
import com.example.oasis.po.Produce;

public class ProduceVO {

    private Integer create_id;

    private Integer paper_id;

    private Integer author_id;

    private Paper paper;

    private Author author;

    public ProduceVO(){

    }

    public ProduceVO(Produce produce){
        this.create_id=produce.getCreate_id();
        this.paper_id=produce.getPaper_id();
        this.author_id=produce.getAuthor_id();
        this.paper=produce.getPaper();
        this.author=produce.getAuthor();
    }

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
        return "ProduceVO{" +
                "create_id=" + create_id +
                ", paper_id=" + paper_id +
                ", author_id=" + author_id +
                '}';
    }
}
