package com.example.oasis.blImpl.update;


import com.example.oasis.bl.update.UpdateService;
import com.example.oasis.data.update.UpdateServiceMapper;
import com.example.oasis.po.Author;
import com.example.oasis.po.Meeting;
import com.example.oasis.po.Paper;
import com.example.oasis.po.Publish;
import com.example.oasis.utils.CSVFile;
import com.example.oasis.utils.FtpBean;
import com.example.oasis.utils.FtpUtil;
import com.example.oasis.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;


@Service
public class UpdateServiceImpl implements UpdateService {

    @Autowired
    private UpdateServiceMapper updateServiceMapper;

    private List<Author> authorArrayList;
    private List<Paper> papers;
    private List<Publish> publishes;
    private List<Meeting> meetings;
    private List<String> publishRelation;
    private List<String> createRelation;

    @Override
    public ResponseVO upload(File file, String filename) {
        FtpBean ftp = new FtpBean();
        ftp.setFileName(filename);
        try {
            //将文件转换成一个输入流
            InputStream in = new FileInputStream(file);
            ftp.setInputStream(in);
            //传入文件名称，和文件输入流，上传至FTP服务器
            boolean isOk = FtpUtil.uploadFile(ftp);
            if (!isOk) {
                return ResponseVO.buildFailure("文件上传失败");
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO update(String filename) {
        InputStream in = null;
        BufferedReader reader = null;
        CSVFile csvFile = new CSVFile();
        FtpBean ftp = new FtpBean();
        ftp.setFileName(filename + ".csv");
        try {
            in = FtpUtil.readFile(ftp);
            if (in != null) {
                csvFile.readCSV(in);
            } else {
                return ResponseVO.buildFailure("文件读取失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        获取csv文件中解析处理好的数据
        authorArrayList = csvFile.getAuthorArrayList();
        papers = csvFile.getPapers();
        publishes = csvFile.getPublishes();
        meetings = csvFile.getMeetings();
        publishRelation = csvFile.getPublishRelation();
        createRelation = csvFile.getCreateRelation();
//        通过循环调用sql语句,更新数据
        for (Paper p : papers) {
            PaperVO paperVO = new PaperVO(p);
            System.out.println(paperVO);
            updateServiceMapper.insertPaper(paperVO);
        }
        for (Author author : authorArrayList) {
            AuthorVO authorVO = new AuthorVO(author);
            System.out.println(authorVO);
            updateServiceMapper.insertAuthor(authorVO);
        }
        for (Meeting meeting : meetings) {
            MeetingVO meetingVO = new MeetingVO(meeting);
            System.out.println(meetingVO);
            updateServiceMapper.insertMeeting(meetingVO);
        }

        int index = 0;
        for (Publish publish : publishes) {
            String string = publishRelation.get(index);
            String[] strings = string.split(";");
            index++;
            Meeting meeting = updateServiceMapper.selectMeeting(strings[0]);
            Paper paper = updateServiceMapper.selectPaperByTitle(strings[1]);
            PublishVO publishVO = new PublishVO(publish);
            publishVO.setMeeting(meeting);
            publishVO.setPaper(paper);
            updateServiceMapper.insertPublish(publishVO);
        }

        for (String s : createRelation) {
            String[] strings = (s + "").split(";");
            System.out.println(strings[0] + " " + strings[1]);
            Paper paper = updateServiceMapper.selectPaperByTitle(strings[0]);
            Author author = updateServiceMapper.selectAuthorByName(strings[1]);
            ProduceVO produceVO = new ProduceVO();
            produceVO.setAuthor(author);
            produceVO.setPaper(paper);

            System.out.println(author.getAuthor_id() + " " + paper.getPaper_id());
            updateServiceMapper.insertProduce(produceVO);
        }
        return ResponseVO.buildSuccess();
    }
// 迭代二中本地文件添加csv文件的接口，迭代三中改为将csv文件上传到ftp服务器
//    @Override
//    public String addCSV(String fielpath){
//        CSVFile csvFile=new CSVFile();
//        try {
//            csvFile.readCSV(fielpath);
//            authorArrayList=csvFile.getAuthorArrayList();
//            papers=csvFile.getPapers();
//            publishes=csvFile.getPublishes();
//            meetings=csvFile.getMeetings();
//            publishRelation=csvFile.getPublishRelation();
//            createRelation=csvFile.getCreateRelation();
//            for(Paper p:papers){
//                PaperVO paperVO=new PaperVO(p);
//                System.out.println(paperVO);
//                updateServiceMapper.insertPaper(paperVO);
//            }
//            for(Author author:authorArrayList){
//                AuthorVO authorVO = new AuthorVO(author);
//                System.out.println(authorVO);
//                updateServiceMapper.insertAuthor(authorVO);
//            }
//            for(Meeting meeting:meetings){
//                MeetingVO meetingVO = new MeetingVO(meeting);
//                System.out.println(meetingVO);
//                updateServiceMapper.insertMeeting(meetingVO);
//            }
//
//            int index=0;
//            for(Publish publish:publishes){
//                String string=publishRelation.get(index);
//                String[] strings=string.split(";");
//                index++;
//                Meeting meeting = updateServiceMapper.selectMeeting(strings[0]);
//                Paper paper = updateServiceMapper.selectPaperByTitle(strings[1]);
//                PublishVO publishVO= new PublishVO(publish);
//                publishVO.setMeeting(meeting);
//                publishVO.setPaper(paper);
//                updateServiceMapper.insertPublish(publishVO);
//            }
//
//            for(String s:createRelation){
//                String[] strings=(s+"").split(";");
//                System.out.println(strings[0]+" "+strings[1]);
//                Paper paper=updateServiceMapper.selectPaperByTitle(strings[0]);
//                Author author=updateServiceMapper.selectAuthorByName(strings[1]);
//                ProduceVO produceVO = new ProduceVO();
//                produceVO.setAuthor(author);
//                produceVO.setPaper(paper);
//
//                System.out.println(author.getAuthor_id()+" "+paper.getPaper_id());
//                updateServiceMapper.insertProduce(produceVO);
//            }
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//return ResponseVO.buildSuccess();
//    }
}
