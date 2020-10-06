package com.example.oasis.vo;

import com.example.oasis.po.Meeting;
import com.example.oasis.po.Paper;
import com.example.oasis.po.Publish;

public class PublishVO {
    private Integer publish_id;

    private Meeting meeting;

    private Paper paper;

//    private Integer meeting_id;
//
//    private Integer paper_id;

    private String Publication_Title;

    private Integer Publication_Year;

    private Integer Volume;

    private Integer Issue;

    private Integer Start_Page;

    private Integer End_Page;

    public PublishVO(Publish publish){
        this.meeting=publish.getMeeting();
        this.paper=publish.getPaper();
        this.End_Page=publish.getEnd_page();
        this.publish_id = publish.getPublish_id();
        this.Issue = publish.getIssue();
        //this.meeting_id = publish.getMeeting_id();
        //this.paper_id = publish.getPaper_id();
        this.Publication_Title = publish.getPublication_Title();
        this.Publication_Year = publish.getPublication_Year();
        this.Start_Page = publish.getStart_Page();
        this.Volume = publish.getVolume();
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

    public Integer getPublish_id() {
        return publish_id;
    }

    public void setPublish_id(Integer publish_id) {
        this.publish_id = publish_id;
    }

//    public Integer getMeeting_id() {
//        return meeting_id;
//    }
//
//    public void setMeeting_id(Integer meeting_id) {
//        this.meeting_id = meeting_id;
//    }
//
//    public Integer getPaper_id() {
//        return paper_id;
//    }
//
//    public void setPaper_id(Integer paper_id) {
//        this.paper_id = paper_id;
//    }

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

    public Integer getEnd_Page() {
        return End_Page;
    }

    public void setEnd_Page(Integer end_Page) {
        End_Page = end_Page;
    }

    @Override
    public String toString() {
        return "PublishVO{" +
                "publish_id=" + publish_id +
                ", meeting_id=" + meeting+
                ", paper_id=" + paper +
                ", Publication_Title='" + Publication_Title + '\'' +
                ", Publication_Year=" + Publication_Year +
                ", Volume=" + Volume +
                ", Issue=" + Issue +
                ", Start_Page=" + Start_Page +
                ", End_page=" + End_Page +
                '}';
    }
}
