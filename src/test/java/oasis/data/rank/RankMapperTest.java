package oasis.data.rank;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
//加载主启动类
@SpringBootTest
public class RankMapperTest {
    @Autowired
    RankMapper rankMapper;

    @Test
    public void getTopAuthors() {
       List res=rankMapper.getTopAuthors();
       assertEquals(res.size(),5);
    }


    @Test
    public void getTopReferences() {
        List res=rankMapper.getTopReferences();
        assertEquals(res.size(),5);
    }

    @Test
    public void getTopKeyWords() {
        List res=rankMapper.getTopKeyWords();
        assertEquals(res.size(),5);
    }

    @Test
    public void getAseTopAffiliations() {
        List res=rankMapper.getAseTopAffiliations();
        assertEquals(res.size(),5);

    }

    @Test
    public void getIcseTopAffiliations() {
        List res=rankMapper.getIcseTopAffiliations();
        assertEquals(res.size(),5);
    }
}