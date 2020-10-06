package oasis.service.chart;

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
public class ChartServiceImplTest {
    @Autowired
    ChartServiceImpl chartService;

    @Test
    public void getArticlePerYearByKeyword() {
        BasicResponse br=chartService.getArticlePerYearByKeyword(1);
        assertEquals(br.getStatus().getCode(),"0000");

    }

    @Test
    public void getReferencePerYearByPublication() {
        BasicResponse br=chartService.getReferencePerYearByPublication("ASE");
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void getHindexPerYearByPublication() {
        BasicResponse br=chartService.getHindexPerYearByPublication("ASE");
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void getArticlePerYearByPublication() {
        BasicResponse br=chartService.getArticlePerYearByPublication("ASE");
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void getTopKeywordByPublication() {
        BasicResponse br=chartService.getTopKeywordByPublication("ASE");
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void getAuthorAnnualArticle() {
        BasicResponse br=chartService.getAuthorAnnualArticle(1);
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void getAffiliationAnnualArticle() {
        BasicResponse br=chartService.getAffiliationAnnualArticle(1);
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void getKeywordDistribution() {
        BasicResponse br=chartService.getKeywordDistribution(2);
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void getAffiliationAnnualHindex() {
        BasicResponse br=chartService.getAffiliationAnnualHindex(1);
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void getRefPerYearBykeyword() {
        BasicResponse br=chartService.getRefPerYearBykeyword(1);
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void getHindexPerYearByKeyword() {
        BasicResponse br=chartService.getHindexPerYearByKeyword(1);
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void getReferencePerYearByAuthor() {
        BasicResponse br=chartService.getReferencePerYearByAuthor(1);
        assertEquals(br.getStatus().getCode(),"0000");
    }
}