package oasis.data.search;

import oasis.entity.ArticlePO;
import org.junit.Test;

import static org.junit.Assert.*;


import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
//加载主启动类
@SpringBootTest
public class SearchMapperTest {
    @Autowired
    SearchMapper searchMapper;

    @Test
    public void getArtDetailById() {
        ArticlePO articlePO= searchMapper.getArtDetailById(1);
        assertEquals(articlePO.getDocTitle(),"Big problems in industry (panel)");
        assertEquals(articlePO.getEndPage(),3);
        assertEquals(articlePO.getPublicationId(),1);
        assertEquals(articlePO.getReference(),0);
        assertEquals(articlePO.getPdfLink(),"https://ieeexplore.ieee.org/stamp/stamp.jsp?arnumber=6693060");
    }

//    @Test
//    public void getDocIdList() {
//        List<String> p1=new ArrayList<>();
//        List<String> p2=new ArrayList<>();
//        List<String> p3=new ArrayList<>();
//        p1.add("J. Penix");
//        List<Integer> list=searchMapper.getDocIdList(p1,p2,"",p3,"0","0");
//        assertEquals(list.size(),1);
//
//    }
}