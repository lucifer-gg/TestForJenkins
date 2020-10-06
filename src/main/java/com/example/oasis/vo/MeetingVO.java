package com.example.oasis.vo;

import com.example.oasis.po.Meeting;

public class MeetingVO {

    private Integer meeting_id;

    private String publisher;

    private String Document_Identifier;

    public MeetingVO(Meeting meeting){
        this.Document_Identifier = meeting.getDocument_Identifier();
        this.meeting_id = meeting.getMeeting_id();
        this.publisher=meeting.getPublisher();
    }

    public Integer getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(Integer meeting_id) {
        this.meeting_id = meeting_id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDocument_Identifier() {
        return Document_Identifier;
    }

    public void setDocument_Identifier(String document_Identifier) {
        Document_Identifier = document_Identifier;
    }

    @Override
    public String toString() {
        return "MeetingVO{" +
                "meeting_id=" + meeting_id +
                ", publisher='" + publisher + '\'' +
                ", Document_Identifier='" + Document_Identifier + '\'' +
                '}';
    }
}
