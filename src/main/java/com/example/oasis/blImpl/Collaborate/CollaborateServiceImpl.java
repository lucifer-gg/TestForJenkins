package com.example.oasis.blImpl.Collaborate;


import com.example.oasis.vo.*;
import com.example.oasis.data.Collaborate.CollaborateMapper;
import com.example.oasis.bl.Collaborate.CollaborateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CollaborateServiceImpl implements  CollaborateService {
    @Autowired
    private CollaborateMapper collaborateMapper;

    private static String REGEX_CHINESE = "[\u4e00-\u9fa5]";// 中文正则
    public ResponseVO getCollaborateByAuthor(int authorId){
        //初始化结果
        List<CollaborateOne> cos=new ArrayList<>();
        //根据作者的id来获得有关的数据
        List<CollaborateChange> ccs=collaborateMapper.findCollaborationByAuthorId(authorId);
        List<String> as=new ArrayList<>();

        if(ccs.size()!=0) {
            for (int i = 0; i < ccs.size(); i++) {
                //去除作者名字重复的情况
                if (!ccs.get(i).getAuthor1().trim().equals(ccs.get(i).getAuthor2().trim())) {
                    if (!as.contains(ccs.get(i).getAuthor1().trim() + ccs.get(i).getAuthor2().trim())) {
                        //初始化一个对象来设置各种属性
                        CollaborateOne co=new CollaborateOne();
                        co.setAuthor1(testStr(ccs.get(i).getAuthor1().trim()));
                        co.setAuthor2(testStr(ccs.get(i).getAuthor2().trim()));
                        co.setAuthorId1(ccs.get(i).getAuthorId1());
                        co.setAuthorId2(ccs.get(i).getAuthorId2());
                        co.setTimes(ccs.get(i).getTimes());
                        //添加到结果中去
                        cos.add(co);
                        //as用来防止重复
                        as.add(ccs.get(i).getAuthor1().trim() + ccs.get(i).getAuthor2().trim());
                    }
                }
            }
            return  ResponseVO.buildSuccess(cos);
        }
        return  ResponseVO.buildSuccess();

    }
    public ResponseVO getCollaborateByOrgan(String organ){
        //初始化结果
        List<CollaborateTwo> cts=new ArrayList<>();
        //根据机构的名字来找到对应的合作关系
        List<CollaborateChange> ccs=collaborateMapper.findCollaborationByOrgan(organ);
        List<String> os=new ArrayList<>();
        if(ccs.size()!=0){
            for (int i = 0; i < ccs.size(); i++) {
                //防止机构名字重复
                if(!ccs.get(i).getOrgan1().trim().equals(ccs.get(i).getOrgan2().trim())) {
                    if (!os.contains(ccs.get(i).getOrgan1().trim() + ccs.get(i).getOrgan2().trim())) {
                        //初始化对象来设置各种属性
                        CollaborateTwo ct=new CollaborateTwo();
                        ct.setOrgan1(ccs.get(i).getOrgan1().trim());
                        ct.setOrgan2(ccs.get(i).getOrgan2().trim());
                        ct.setTimes(ccs.get(i).getTimes());
                        //添加到结果中去
                        cts.add(ct);
                        //os防止重复
                        os.add(ccs.get(i).getOrgan1().trim() + ccs.get(i).getOrgan2().trim());
                    }
                }
            }
            return  ResponseVO.buildSuccess(cts);
        }
        return  ResponseVO.buildSuccess();


    }


    // 去除中文的函数
    public  String testStr(String s) {
        Pattern pat = Pattern.compile(REGEX_CHINESE);
        Matcher mat = pat.matcher(s);
        return mat.replaceAll("");
    }
}
