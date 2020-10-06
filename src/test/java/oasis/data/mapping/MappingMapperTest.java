package oasis.data.mapping;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
//加载主启动类
@SpringBootTest
public class MappingMapperTest {
    @Autowired
    private MappingMapper mapper;


    @Test
    public void getKeyWordsIdList() {
        List<Integer> res= mapper.getKeyWordsIdList(2);
        assertEquals(res.size(),3);
    }

    @Test
    public void getAuthorsIdList() {
        List<Integer> res=mapper.getAuthorsIdList(1);
        assertEquals(res.size(),1);

    }

    @Test
    public void getAffiliationIdList() {
        List<Integer> res=mapper.getAffiliationIdList(1);
        assertEquals(res.size(),1);
    }

    @Test
    public void getArtIdByAuthorId() {
        List<Integer> res=mapper.getArtIdByAuthorId(1);
        assertEquals(res.size(),1);
    }

    @Test
    public void getArtIdByAffiliationId() {
        List<Integer> res=mapper.getArtIdByAffiliationId(1);
        assertEquals(res.size(),1);
    }

    @Test
    public void getKeyWordById() {
        String res=mapper.getKeyWordById(1);
        assertEquals(res,"Program Repair");
    }

    @Test
    public void getAuthorById() {
        String res=mapper.getAuthorById(2);
        assertEquals(res,"A. Ghanbari");
    }

    @Test
    public void getAffiliationById() {
        String res=mapper.getAffiliationById(2);
        assertEquals(res,"University of Texas at Dallas");
    }

    @Test
    public void getPublicationTitleById() {
        String res=mapper.getPublicationTitleById(1);
        assertEquals(res,"2013 28th IEEE/ACM International Conference on Automated Software Engineering (ASE)");
    }

    @Test
    public void getPublicationYearById() {
        String res=mapper.getPublicationYearById(1);
        assertEquals(res,"2013");
    }
}