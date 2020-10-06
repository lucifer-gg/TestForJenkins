package com.example.oasis.blImpl.Interface;

import com.example.oasis.data.Interface.InterfaceServiceMapper;
import com.example.oasis.vo.AuthorPaper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InterfaceServiceImpltest {
 @Autowired
    private InterfaceServiceMapper interfaceServiceMapper;
    @Autowired
    private InterfaceServiceImpl interfaceService;
    @Test
    public void test1(){
        interfaceService.authorInterface(1);
    }
    @Test
    public void test2(){
        interfaceService.paperInterface(1);
    }
   /* @Test
    public void test3(){
        interfaceService.paperInterface(4);
    }*/
    @Test
    public void test4(){
        interfaceService.totalHotNumGet(1);
    }
    @Test
    public void test5(){interfaceService.getPaperHot(1);}
    @Test
    public void test6(){interfaceService.getPaperRank();}
   /* @Test
    public void test5(){

        interfaceService.LikePaper(2);
    }*/



}
