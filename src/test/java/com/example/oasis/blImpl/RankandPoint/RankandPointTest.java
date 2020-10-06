package com.example.oasis.blImpl.RankandPoint;
import com.example.oasis.data.Interface.InterfaceServiceMapper;
import com.example.oasis.vo.AuthorPaper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RankandPointTest {
    @Autowired
    private RankandPointServiceImpl rankandPointService;
    @Test
    public  void test1(){
        rankandPointService.AuthorRank("Survey");
    }
}
