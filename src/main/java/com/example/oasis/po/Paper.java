package com.example.oasis.po;


import java.util.List;
import java.util.Objects;

public class Paper {
    private Integer paper_id;



    private String Document_Title;

    private String Date_added_to_Xplore;

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

    private List<String> author;

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public Integer getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(Integer paper_id) {
        this.paper_id = paper_id;
    }





    public String getDate_added_to_Xplore() {
        return Date_added_to_Xplore;
    }

    public void setDate_added_to_Xplore(String date_added_to_Xplore) {
        Date_added_to_Xplore = date_added_to_Xplore;
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

    public String getLicense() {
        return License;
    }

    public void setLicense(String license) {
        License = license;
    }

    public String getDocument_Title() {
        return Document_Title;
    }

    public void setDocument_Title(String document_Title) {
        Document_Title = document_Title;
    }

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String anAbstract) {
        Abstract = anAbstract;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "paper_id=" + paper_id +
                ", Document_Title='" + Document_Title + '\'' +
                ", Date_added_to_Xplore='" + Date_added_to_Xplore + '\'' +
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paper paper = (Paper) o;
        return Objects.equals(getDocument_Title(), paper.getDocument_Title());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDocument_Title());
    }
}
