package com.example.oasis.blImpl.show;

import com.example.oasis.bl.show.ShowService;
import com.example.oasis.data.show.ShowServiceMapper;
import com.example.oasis.po.Author;
import com.example.oasis.po.Meeting;
import com.example.oasis.po.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShowServiceImpl implements ShowService {


    @Autowired
    private ShowServiceMapper showServiceMapper;

    @Override
    public Paper getPaperByTitle(String title){
        try {
            return showServiceMapper.selectPaperByTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Author getAuthorByName(String name){
        try{
            return  showServiceMapper.selectAuthorByName(name);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Meeting getMeeting(String publish){
        try{
            return  showServiceMapper.selectMeeting(publish);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Paper> getRankPaper(){
        try {
            List<Paper> paperList=showServiceMapper.selectRankPaper();
            for(Paper paper:paperList){
                Paper tem=showServiceMapper.selectPaperByTitle(paper.getDocument_Title());
//                根据论文id获取论文作者
                List<String> strings=showServiceMapper.getPaperAuthor(tem.getPaper_id().intValue());
                paper.setAuthor(strings);
            }
            return paperList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Author> getRankAuthor(){
        try{
            List<Author> authorList=showServiceMapper.selectRankAuthor();

            for(Author author:authorList){
                Author temauthor=showServiceMapper.selectAuthorByName(author.getAuthor_name());
                int id=showServiceMapper.getPaperNum(temauthor.getAuthor_id().intValue());
                author.setPapernum(Integer.valueOf(id));
            }
            return authorList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }



}




