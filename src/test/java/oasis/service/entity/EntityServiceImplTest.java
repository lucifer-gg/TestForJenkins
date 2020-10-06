package oasis.service.entity;

import oasis.vo.BasicResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
//加载主启动类
@SpringBootTest
public class EntityServiceImplTest {
    @Autowired
    EntityServiceImpl entityService;


    @Test
    public void searchAuthor() {
        BasicResponse br=entityService.searchAuthor("A. Ghanbari");
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void searchAffiliation() {
        BasicResponse br=entityService.searchAffiliation("Google, USA");
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void searchPublication() {
        BasicResponse br=entityService.searchPublication("ASE");
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void searchKeyword() {
        BasicResponse br=entityService.searchKeyword("Program Repair");
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void authorPortrait() {
        BasicResponse br=entityService.authorPortrait(1);
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void affiliationPortrait() {
        BasicResponse br=entityService.affiliationPortrait(1);
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void publicationPortrait() {
        BasicResponse br=entityService.publicationPortrait("ASE");
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void keywordPortrait() {
        BasicResponse br=entityService.keywordPortrait(1);
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void getRelatedAuthors() {
        BasicResponse br=entityService.getRelatedAuthors(1);
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void getSubAuthorsByAffiliation() {
        BasicResponse br=entityService.getSubAuthorsByAffiliation(1);
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void recommendAuthors() {
        BasicResponse br=entityService.recommendAuthors(1);
        assertEquals(br.getStatus().getCode(),"0000");
    }


}