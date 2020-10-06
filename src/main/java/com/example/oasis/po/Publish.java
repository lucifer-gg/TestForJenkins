package com.example.oasis.po;

import java.util.Objects;

public class Publish {

    private Integer publish_id;

    private Meeting meeting;

    private  Paper paper;

    private Integer meeting_id;

    private Integer paper_id;

    private String Publication_Title;

    private Integer Publication_Year;

    private Integer Volume;

    private Integer Issue;

    private Integer Start_Page;

    private Integer End_page;

    public Integer getPublish_id() {
        return publish_id;
    }

    public void setPublish_id(Integer publish_id) {
        this.publish_id = publish_id;
    }

    public Integer getMeeting_id() {
        return meeting.getMeeting_id();
    }

    public Integer getPaper_id() {
        return paper.getPaper_id();
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public String getPublication_Title() {
        return Publication_Title;
    }

    public void setPublication_Title(String publication_Title) {
        Publication_Title = publication_Title;
    }

    public Integer getPublication_Year() {
        return Publication_Year;
    }

    public void setPublication_Year(Integer publication_Year) {
        Publication_Year = publication_Year;
    }

    public Integer getVolume() {
        return Volume;
    }

    public void setVolume(Integer volume) {
        Volume = volume;
    }

    public Integer getIssue() {
        return Issue;
    }

    public void setIssue(Integer issue) {
        Issue = issue;
    }

    public Integer getStart_Page() {
        return Start_Page;
    }

    public void setStart_Page(Integer start_Page) {
        Start_Page = start_Page;
    }

    public Integer getEnd_page() {
        return End_page;
    }

    public void setEnd_page(Integer end_page) {
        End_page = end_page;
    }

    @Override
    public String toString() {
        return "Publish{" +
                "publish_id=" + publish_id +
                ", meeting_id=" + meeting_id +
                ", paper_id=" + paper_id +
                ", Publication_Title='" + Publication_Title + '\'' +
                ", Publication_Year=" + Publication_Year +
                ", Volume=" + Volume +
                ", Issue=" + Issue +
                ", Start_Page=" + Start_Page +
                ", End_page=" + End_page +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publish publish = (Publish) o;
        return Objects.equals(getPublication_Title(), publish.getPublication_Title()) &&
                Objects.equals(getPublication_Year(), publish.getPublication_Year()) &&
                Objects.equals(getVolume(), publish.getVolume()) &&
                Objects.equals(getIssue(), publish.getIssue()) &&
                Objects.equals(getStart_Page(), publish.getStart_Page()) &&
                Objects.equals(getEnd_page(), publish.getEnd_page());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPublication_Title(), getPublication_Year(), getVolume(), getIssue(), getStart_Page(), getEnd_page());
    }
}
