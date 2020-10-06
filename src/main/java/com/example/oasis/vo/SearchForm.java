package com.example.oasis.vo;
public class SearchForm {
    private String author;//作者名字 模糊匹配
    private String meeting;//会议名字 模糊匹配
    private String organ;// 机构名字 出版商名字 模糊匹配
    private int startTime;//出版年份匹配
    private int endTime;//出版年份匹配
    private String keyword;//标题 模糊匹配
    public String getAuthor(){return author;}
    public void setAuthor(String author){this.author=author;}
    public String getMeeting(){return meeting;}
    public void setMeeting(String meeting){this.meeting=meeting;}
    public String getOrgan(){return organ;}
    public void setOrgan(String organ){this.organ=organ;}
    public int getStartTime(){return startTime;}
    public void setStartTime(int startTime){this.startTime=startTime;}
    public int getEndTime(){return endTime;}
    public void setEndTime(int endTime){this.endTime=endTime;}
    public String getKeyword(){return keyword;}
    public void setKeyword(String keyword){this.keyword=keyword;}


}
