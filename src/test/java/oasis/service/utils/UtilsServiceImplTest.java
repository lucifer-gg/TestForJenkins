package oasis.service.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
//加载主启动类
@SpringBootTest
public class UtilsServiceImplTest {
    @Autowired
    UtilsServiceImpl utilsService;

    @Test
    public void getKeyWordIdByName() {
        assertEquals(utilsService.getKeyWordIdByName("Program Repair").getData().toString(),"1");
    }

    @Test
    public void getPublicationIdByName() {
        assertEquals(utilsService.getPublicationIdByName("2013 28th IEEE/ACM International Conference on Automated Software Engineering (ASE)").getData().toString(),"1");
    }

    @Test
    public void getAffiliationIdByName() {
        assertEquals(utilsService.getAffiliationIdByName("Google, USA").getData().toString(),"1");
    }

    @Test
    public void strToList() {
        String[] array =new String[1];
        array[0]="1234";
        List list = Arrays.asList(array);

        assertEquals(utilsService.strToList("1234"),list);
    }

    @Test
    public void removeDuplicate() {

        List a=new ArrayList();
        a.add(1);
        a.add(1);
        a.add(2);
        a.add(3);
        List b=new ArrayList();
        b.add(1);
        b.add(2);
        b.add(3);
        assertEquals(utilsService.removeDuplicate(a),b);
    }

    @Test
    public void listToSqlList() {
        List a=new ArrayList();
        a.add(1);
        assertEquals(utilsService.listToSqlList(a),"'1'");

    }

    @Test
    public void calHIndex() {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        assertEquals(utilsService.calHIndex(list),2);
    }
}