package oasis.service.search;

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
public class SearchServiceImplTest {
    @Autowired
    SearchServiceImpl searchService;

    @Test
    public void getArtItem() {
        SearchParam sp=new SearchParam("A. Ghanbari","","","","2013-2020");
        BasicResponse br = searchService.getArtItem(sp);
        assertEquals(br.getStatus().getCode(),"0001");

    }

    @Test
    public void getArtItem2() {
        SearchParam sp=new SearchParam("","","","","2013-2020");
        BasicResponse br =searchService.getArtItem(sp);
        assertEquals(br.getStatus().getCode(),"0001");

    }

    @Test
    public void getArtDetailById() {
        BasicResponse br=searchService.getArtDetailById(1);
        assertEquals(br.getStatus().getCode(),"0000");

    }
    @Test
    public void getArtDetailById2() {
        BasicResponse br=searchService.getArtDetailById(0);
        assertEquals(br.getStatus().getCode(),"0001");

    }


}