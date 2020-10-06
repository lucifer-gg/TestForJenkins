package com.example.oasis.blImpl.Collaborate;
import com.example.oasis.bl.Collaborate.CollaborateService;
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
public class CollaborationTest {
    @Autowired
    private CollaborateServiceImpl collaborateService;
    @Test
    public  void test1(){collaborateService.getCollaborateByAuthor(1) ;}
    @Test
    public  void test2(){collaborateService.getCollaborateByOrgan("Madrid"); }
}
