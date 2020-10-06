package com.example.oasis.vo;


import java.util.ArrayList;
import java.util.List;

public class SearchResult {
    private int paperid;
    private String title;
    private List<String> author=new ArrayList<>();
    private List<Integer> authorid=new ArrayList<>();
    private int time;
    private String publicationTitle;
    private String pdfLink;
    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}
    public int getTime(){return time;}
    public void setTime(int time){this.time=time;}
    public String getPublicationTitle(){return publicationTitle;}
    public void setPublicationTitle(String publicationTitle){this.publicationTitle=publicationTitle;}
    public String getPdfLink(){return pdfLink;}
    public void setPdfLink(String pdfLink){this.pdfLink=pdfLink;}
    public void addauthor(String a){
        this.author.add(a);
    }
    public void addauthorids(Integer id){
        this.authorid.add(id);
    }
    public int getPaperid() {
        return paperid;
    }

    public void setPaperid(int paperid) {
        this.paperid = paperid;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public List<Integer> getAuthorid() {
        return authorid;
    }

    public void setAuthorid(List<Integer> authorid) {
        this.authorid = authorid;
    }
}
