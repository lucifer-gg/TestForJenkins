package com.example.oasis.po;

import java.util.Objects;

public class Meeting {

    private Integer meeting_id;

    private String publisher;

    private String Document_Identifier;

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
        return "Meeting{" +
                "meeting_id=" + meeting_id +
                ", publisher='" + publisher + '\'' +
                ", Document_Identifier='" + Document_Identifier + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(getPublisher(), meeting.getPublisher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPublisher());
    }
}
