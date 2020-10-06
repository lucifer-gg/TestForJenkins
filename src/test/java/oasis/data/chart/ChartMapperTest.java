package oasis.data.chart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
//加载主启动类
@SpringBootTest
public class ChartMapperTest {
    @Autowired
    ChartMapper chartMapper;

    @Test
    public void getHindexPerYearByTitle() {
        assertEquals(chartMapper.getHindexPerYearByTitle("ASE").get(0).getHindex(),33);
    }

    @Test
    public void getAnnualArticles() {
        assertEquals(chartMapper.getAnnualArticles("1").get(0).getArticleNum(),1);
    }

    @Test
    public void getKeywordDist() {
        assertEquals(chartMapper.getKeywordDist("1").get(0).getArticleNum(),12);
    }
}