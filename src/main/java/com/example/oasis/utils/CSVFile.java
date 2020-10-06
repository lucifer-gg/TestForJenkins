package com.example.oasis.utils;

import com.example.oasis.blImpl.update.UpdateServiceImpl;
import com.example.oasis.data.update.UpdateServiceMapper;
import com.example.oasis.po.Author;
import com.example.oasis.po.Meeting;
import com.example.oasis.po.Paper;
import com.example.oasis.po.Publish;
import com.example.oasis.vo.AuthorVO;
import com.example.oasis.vo.MeetingVO;
import com.example.oasis.vo.PaperVO;
import com.example.oasis.vo.PublishVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CSVFile {
    private List<Author> authorArrayList;
    private List<Paper> papers;
    private List<Publish> publishes;
    private List<Meeting> meetings;
    private List<String> publishRelation;
    private List<String> createRelation;

    public void readCSV(InputStream in) {
//        File inFile = new File(readpath);
        authorArrayList=new ArrayList<>();
        papers = new ArrayList<>();
        publishes = new ArrayList<>();
        meetings = new ArrayList<>();
        publishRelation= new ArrayList<>();
        createRelation = new ArrayList<>();
        try {
//            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String title = reader.readLine();
            String[] key = title.split(",");
            while (reader.ready()) {
                int n=0;
                String line = reader.readLine();
                String[] datas=line.split(",");
                Meeting meeting = new Meeting();
                Paper paper = new Paper();
                Publish publish = new Publish();

                paper.setDocument_Title(datas[0]);
                String[] author_names = datas[1].split(";");
                n=author_names.length;
                ArrayList<Author> authors = new ArrayList<>(n);
                String[] author_affiliations = datas[2].split(";");
                for(int i=0;i<n;i++){
                    Author author=new Author();
                    author.setAuthor_name(author_names[i]);
                    if(!createRelation.contains(datas[0]+";"+author_names[i])) {
                        createRelation.add(datas[0] + ";" + author_names[i]);
                    }
                    author.setAuthor_affiliations(author_affiliations[i]);
                    author.setFunding_Information("");
                    author.setAuthor_keywords(datas[16]);
                    authors.add(author);
                }
                //author
                //author_affiliations
                publish.setPublication_Title(datas[3]);
                paper.setDate_added_to_Xplore(datas[4]);
                publish.setPublication_Year(Integer.valueOf(datas[5]));
                if(datas[6].isEmpty()){
                    publish.setVolume(0);
                }
                else {
                    publish.setVolume(Integer.valueOf(datas[6]));
                }
                if(datas[7].isEmpty()){
                    publish.setIssue(0);
                }
                else {
                    publish.setIssue(Integer.valueOf(datas[7]));
                }
                if(datas[8].isEmpty()){
                    publish.setStart_Page(0);
                }
                else {
                    publish.setStart_Page(Integer.valueOf(datas[8]));
                }
                if(datas[9].isEmpty()){
                    publish.setEnd_page(0);
                }
                else {
                    publish.setEnd_page(Integer.valueOf(datas[9]));
                }
                paper.setAbstract(datas[10]);
                paper.setISSN(datas[11]);
                paper.setISBNs(datas[12]);
                paper.setDOI(datas[13]);
                //funding_informatioan
                paper.setPDF_Link(datas[15]);
                //author_keywords
                paper.setIEEE_Terms(datas[17]);
                paper.setINSPEC_Controlled_Terms(datas[18]);
                paper.setINSPEC_Non_Controlled_Terms(datas[19]);
                paper.setMesh_Terms(datas[20]);
                if(datas[21].isEmpty()){
                    paper.setArticle_Citation_Count(0);
                }
                else {
                    paper.setArticle_Citation_Count(Integer.valueOf(datas[21]));
                }
                if(datas[22].isEmpty()){
                    paper.setReference_Count(0);
                }
                else {
                    paper.setReference_Count(Integer.valueOf(datas[22]));
                }
                paper.setLicense(datas[23]);
                paper.setOnline_Date(datas[24]);
                paper.setIssue_Date(datas[25]);
                paper.setMeeting_Date(datas[26]);
                meeting.setPublisher(datas[27]);
                meeting.setDocument_Identifier(datas[28]);

                publishRelation.add(datas[27]+";"+datas[0]);

                if(!papers.contains(paper)){
                    papers.add(paper);
                }
                if(!publishes.contains(publish)) {
                    publishes.add(publish);
                }
                if(!meetings.contains(meeting)) {
                    meetings.add(meeting);

                }
                for(Author i:authors){
                    //System.out.println(i);
                    if(!authorArrayList.contains(i)) {
                        authorArrayList.add(i);
                    }
                    else{
                        int index = authorArrayList.indexOf(i);
                        Author author=authorArrayList.get(index);
                        author.setAuthor_keywords(author.getAuthor_keywords()+";"+datas[16]);
                        authorArrayList.remove(index);
                        authorArrayList.add(author);
                    }


                }
            }
            reader.close();
//            for(Author author:authorArrayList){
//                System.out.println(author);
//                System.out.println("=====================");
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getPublishRelation() {
        return publishRelation;
    }

    public List<String> getCreateRelation() {
        return createRelation;
    }

    public List<Author> getAuthorArrayList() {
        return authorArrayList;
    }

    public List<Paper> getPapers() {
        return papers;
    }

    public List<Publish> getPublishes() {
        return publishes;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

//    测试解析csv文件
//    public static void main(String[] args){
        //使用相对路径
//        new CSVFile().readCSV("static\\uploadFile\\demo.csv");
//    }

}


