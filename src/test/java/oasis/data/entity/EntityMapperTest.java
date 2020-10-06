package oasis.data.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
//加载主启动类
@SpringBootTest
public class EntityMapperTest {

    @Autowired
    EntityMapper entityMapper;
    @Test
    public void smartSearchAuthor() {
        assertEquals(entityMapper.smartSearchAuthor("J. Penix").get(0).getAuthorId(),1);
    }

    @Test
    public void blurSearchAuthor() {
        assertEquals(entityMapper.blurSearchAuthor("J. Penix").get(0).getAuthorId(),1);
    }

    @Test
    public void smartSearchAffiliation() {
        assertEquals(entityMapper.smartSearchAffiliation("Google, USA").get(0).getAffiliationId(),1);
    }

    @Test
    public void blurSearchAffiliation() {
        assertEquals(entityMapper.blurSearchAffiliation("Google, USA").get(0).getAffiliationId(),1);
    }

    @Test
    public void searchPublication() {
        assertEquals(entityMapper.searchPublication("ASE").get(0).getHindex().toString(),"33");
    }

    @Test
    public void smartSearchKeyword() {
        assertEquals(entityMapper.smartSearchKeyword("Program Repair").get(0).getKeywordId().toString(),"1");
    }

    @Test
    public void blurSearchKeyword() {
        assertEquals(entityMapper.blurSearchKeyword("Program Repair").get(0).getKeywordId().toString(),"1");
    }

    @Test
    public void authorPortrait() {
        assertEquals(entityMapper.authorPortrait(1).getActivation(),11);
    }

    @Test
    public void affiliationPortrait() {
        assertEquals(entityMapper.affiliationPortrait(1).getActivation(),11);
    }

    @Test
    public void publicationPortrait() {
        assertEquals(entityMapper.publicationPortrait("ASE").toString(),"39");
    }

    @Test
    public void keywordPortrait() {
        assertEquals(entityMapper.keywordPortrait(1).getKeyword(),"Program Repair");
    }

    @Test
    public void getArticleReference() {
        assertEquals(entityMapper.getArticleReference(1),new Integer(0));
    }

    @Test
    public void recommendAuthors() {
        assertEquals(entityMapper.recommendAuthors(1),"184*202*1176");
    }
}