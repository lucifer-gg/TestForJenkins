package oasis.service.rank;

import org.junit.Test;

import static org.junit.Assert.*;
import oasis.bl.search.SearchService;
import oasis.parameter.search.SearchParam;
import oasis.vo.BasicResponse;
import oasis.vo.rank.ArticleVO;
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
public class RankServiceImplTest {
    @Autowired
    RankServiceImpl rankService;

    @Test
    public void getTopAuthors() {
        BasicResponse br=rankService.getTopAuthors();
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void getTopReferences() {
        BasicResponse br=rankService.getTopReferences();
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void getTopKeyWords() {
        BasicResponse br=rankService.getTopReferences();
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void getAseTopAffiliations() {
        BasicResponse br=rankService.getAseTopAffiliations();
        assertEquals(br.getStatus().getCode(),"0000");
    }

    @Test
    public void getIcseTopAffiliations() {
        BasicResponse br=rankService.getIcseTopAffiliations();
        assertEquals(br.getStatus().getCode(),"0000");
    }
}