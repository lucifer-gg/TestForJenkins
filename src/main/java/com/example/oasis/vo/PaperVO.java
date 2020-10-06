package com.example.oasis.vo;

import com.example.oasis.po.Paper;

public class PaperVO {
    private Integer paper_id;

    private String Document_Title;

    private String Date_Added_To_Xplore;

    private String Abstract;

    private String ISSN;

    private String ISBNs;

    private String DOI;

    private String PDF_Link;

    private String IEEE_Terms;

    private String INSPEC_Controlled_Terms;

    private String INSPEC_Non_Controlled_Terms;

    private String Mesh_Terms;

    private Integer Article_Citation_Count;

    private Integer Reference_Count;

    private String Online_Date;

    private String Issue_Date;

    private String Meeting_Date;

    private String License;

    public PaperVO(Paper paper){
        this.License=paper.getLicense();
        this.Document_Title=paper.getDocument_Title();
        this.INSPEC_Non_Controlled_Terms=paper.getINSPEC_Non_Controlled_Terms();
        this.Reference_Count=paper.getReference_Count();
        this.PDF_Link=paper.getPDF_Link();
        this.paper_id=paper.getPaper_id();
        this.Abstract=paper.getAbstract();
        this.Online_Date=paper.getOnline_Date();
        this.Mesh_Terms=paper.getMesh_Terms();
        this.Meeting_Date=paper.getMeeting_Date();
        this.Issue_Date=paper.getIssue_Date();
        this.ISSN=paper.getISSN();
        this.ISBNs=paper.getISBNs();
        this.INSPEC_Controlled_Terms=paper.getINSPEC_Controlled_Terms();
        this.IEEE_Terms=paper.getIEEE_Terms();
        this.DOI=paper.getDOI();
        this.Date_Added_To_Xplore=paper.getDate_added_to_Xplore();
        this.Article_Citation_Count=paper.getArticle_Citation_Count();


    }



    public Integer getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(Integer paper_id) {
        this.paper_id = paper_id;
    }

    public String getDocument_Title() {
        return Document_Title;
    }

    public void setDocument_Title(String document_Title) {
        Document_Title = document_Title;
    }

    public String getLicense() {
        return License;
    }

    public void setLicense(String license) {
        License = license;
    }

    public String getDate_Added_To_Xplore() {
        return Date_Added_To_Xplore;
    }

    public void setDate_Added_To_Xplore(String date_Added_To_Xplore) {
        Date_Added_To_Xplore = date_Added_To_Xplore;
    }

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String anAbstract) {
        Abstract = anAbstract;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public String getISBNs() {
        return ISBNs;
    }

    public void setISBNs(String ISBNs) {
        this.ISBNs = ISBNs;
    }

    public String getDOI() {
        return DOI;
    }

    public void setDOI(String DOI) {
        this.DOI = DOI;
    }

    public String getPDF_Link() {
        return PDF_Link;
    }

    public void setPDF_Link(String PDF_Link) {
        this.PDF_Link = PDF_Link;
    }

    public String getIEEE_Terms() {
        return IEEE_Terms;
    }

    public void setIEEE_Terms(String IEEE_Terms) {
        this.IEEE_Terms = IEEE_Terms;
    }

    public String getINSPEC_Controlled_Terms() {
        return INSPEC_Controlled_Terms;
    }

    public void setINSPEC_Controlled_Terms(String INSPEC_Controlled_Terms) {
        this.INSPEC_Controlled_Terms = INSPEC_Controlled_Terms;
    }

    public String getINSPEC_Non_Controlled_Terms() {
        return INSPEC_Non_Controlled_Terms;
    }

    public void setINSPEC_Non_Controlled_Terms(String INSPEC_Non_Controlled_Terms) {
        this.INSPEC_Non_Controlled_Terms = INSPEC_Non_Controlled_Terms;
    }

    public String getMesh_Terms() {
        return Mesh_Terms;
    }

    public void setMesh_Terms(String mesh_Terms) {
        Mesh_Terms = mesh_Terms;
    }

    public Integer getArticle_Citation_Count() {
        return Article_Citation_Count;
    }

    public void setArticle_Citation_Count(Integer article_Citation_Count) {
        Article_Citation_Count = article_Citation_Count;
    }

    public Integer getReference_Count() {
        return Reference_Count;
    }

    public void setReference_Count(Integer reference_Count) {
        Reference_Count = reference_Count;
    }

    public String getOnline_Date() {
        return Online_Date;
    }

    public void setOnline_Date(String online_Date) {
        Online_Date = online_Date;
    }

    public String getIssue_Date() {
        return Issue_Date;
    }

    public void setIssue_Date(String issue_Date) {
        Issue_Date = issue_Date;
    }

    public String getMeeting_Date() {
        return Meeting_Date;
    }

    public void setMeeting_Date(String meeting_Date) {
        Meeting_Date = meeting_Date;
    }

    @Override
    public String toString() {
        return "PaperVO{" +
                "paper_id=" + paper_id +
                ", Document_Title='" + Document_Title + '\'' +
                ", Date_added_to_Xplore='" + Date_Added_To_Xplore + '\'' +
                ", Abstract='" + Abstract + '\'' +
                ", ISSN='" + ISSN + '\'' +
                ", ISBNs='" + ISBNs + '\'' +
                ", DOI='" + DOI + '\'' +
                ", PDF_Link='" + PDF_Link + '\'' +
                ", IEEE_Terms='" + IEEE_Terms + '\'' +
                ", INSPEC_Controlled_Terms='" + INSPEC_Controlled_Terms + '\'' +
                ", INSPEC_Non_Controlled_Terms='" + INSPEC_Non_Controlled_Terms + '\'' +
                ", Mesh_Terms='" + Mesh_Terms + '\'' +
                ", Article_Citation_Count=" + Article_Citation_Count +
                ", Reference_Count=" + Reference_Count +
                ", Online_Date='" + Online_Date + '\'' +
                ", Issue_Date='" + Issue_Date + '\'' +
                ", Meeting_Date='" + Meeting_Date + '\'' +
                ", License='" + License + '\'' +
                '}';
    }
}
