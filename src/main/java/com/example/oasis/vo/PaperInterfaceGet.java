package com.example.oasis.vo;

import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.List;

public class PaperInterfaceGet {
    private int paperid;
    private  List<Integer> authorid;
    private String title;
    private List<String> author;
    private String Abstract;
    private String titleLink;
    private List<String> IEEE_terms=new ArrayList<>();
    private int time;
    private String publishTitle;
    private int refNum;
    private double paperHotNum;
    private String DOI;
    private List<String> otherPapers=new ArrayList<>();
    private List<String> otherPaperPdfLinks=new ArrayList<>();
    private List<String> otherPaperabs=new ArrayList<>();
    private List<Integer> otherids=new ArrayList<>();
    private List<Integer> othertimes=new ArrayList<>();
    private List<String> otherAuthors=new ArrayList<>();
    public  void addOtherTimes(Integer t){
        this.othertimes.add(t);
    }
    public  void addOtherAuthors(String author){
        this.otherAuthors.add(author);
    }
    public  void addterms(String t) {
    this.IEEE_terms.add(t);
    }
    public  void  addotherPapers(String p){
        this.otherPapers.add(p);
    }
    public  void addotherpdf(String p){
        this.otherPaperPdfLinks.add(p);
    }
    public  void  addids(Integer id){
        this.otherids.add(id);
    }
    public  void addotherabs(String a){
        this.otherPaperabs.add(a);
    }

    public List<Integer> getOthertimes() {
        return othertimes;
    }

    public void setOthertimes(List<Integer> othertimes) {
        this.othertimes = othertimes;
    }

    public List<String> getOtherAuthors() {
        return otherAuthors;
    }

    public void setOtherAuthors(List<String> otherAuthors) {
        this.otherAuthors = otherAuthors;
    }

    public List<String> getIEEE_terms() {
        return IEEE_terms;
    }

    public List<Integer> getOtherids() {
        return otherids;
    }

    public void setOtherids(List<Integer> otherids) {
        this.otherids = otherids;
    }

    public List<String> getOtherPaperabs() {
        return otherPaperabs;
    }

    public void setOtherPaperabs(List<String> otherPaperabs) {
        this.otherPaperabs = otherPaperabs;
    }
    public void setIEEE_terms(List<String> IEEE_terms) {
        this.IEEE_terms = IEEE_terms;
    }

    public void setDOI(String DOI) {
        this.DOI = DOI;
    }

    public List<String> getOtherPapers() {
        return otherPapers;
    }

    public void setOtherPapers(List<String> otherPapers) {
        this.otherPapers = otherPapers;
    }

    public List<String> getOtherPaperPdfLinks() {
        return otherPaperPdfLinks;
    }

    public void setOtherPaperPdfLinks(List<String> otherPaperPdfLinks) {
        this.otherPaperPdfLinks = otherPaperPdfLinks;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public String getDOI() {
        return DOI;
    }
    public String getTitle() {
        return title;
    }

    public String getAbstract() {
        return Abstract;
    }

    public String getTitleLink() {
        return titleLink;
    }



    public int getTime() {
        return time;
    }



    public String getPublishTitle() {
        return publishTitle;
    }

    public int getRefNum() {
        return refNum;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAbstract(String anAbstract) {
        Abstract = anAbstract;
    }

    public void setTitleLink(String titleLink) {
        this.titleLink = titleLink;
    }



    public void setTime(int time) {
        this.time = time;
    }



    public void setPublishTitle(String publishTitle) {
        this.publishTitle = publishTitle;
    }

    public void setRefNum(int refNum) {
        this.refNum = refNum;
    }

    public int getPaperid() {
        return paperid;
    }

    public void setPaperid(int paperid) {
        this.paperid = paperid;
    }

    public List<Integer> getAuthorid() {
        return authorid;
    }

    public void setAuthorid(List<Integer> authorid) {
        this.authorid = authorid;
    }

    public double getPaperHotNum() {
        return paperHotNum;
    }

    public void setPaperHotNum(double paperHotNum) {
        this.paperHotNum = paperHotNum;
    }
}
