package oasis;

import com.csvreader.CsvReader;
import oasis.InitMySQL;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class InitMySQLTest {
    InitMySQL initMySQL=new InitMySQL();
    Connection conn;
    CsvReader cr;

    @Before
    public void init() throws Exception{
        //initMySQL.readFromCsv("jdbc:mysql://localhost:3306/oasis?serverTimezone=UTC","root","123456","datasource/ase13_15_16_17_19.csv","ase");

        conn=initMySQL.initial_con("jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC","root","123456");
        URL url = getClass().getClassLoader().getResource("datasource/test.csv");
        File kkFile = new File(url.getFile());
        InputStream in = new FileInputStream(kkFile);
        cr = new CsvReader(in, ',', Charset.forName("GBK"));
        cr.readHeaders();
        cr.readRecord();
    }


    @Test
    public void removeDuplicate() {
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(4);
        ArrayList<Integer> res=initMySQL.removeDuplicate(arrayList);
        ArrayList<Integer> actual=new ArrayList<>();
        actual.add(0);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        assertEquals(res,actual);
    }

    @Test
    public void insertAffiliAndAuthor() {
        ArrayList<Integer> authorIdList=new ArrayList<>();
        ArrayList<Integer> affiliationIdList=new ArrayList<>();
        ArrayList<Integer> resList=new ArrayList<>();
        resList.add(1);
        resList.add(1);
        initMySQL.insertAffiliAndAuthor(cr,conn,authorIdList,affiliationIdList);
        assertEquals(authorIdList.get(0),resList.get(0));
        assertEquals(affiliationIdList.get(0),resList.get(1));
    }


    @Test
    public void insertKeyword() {
        ArrayList<Integer> keyWordList=new ArrayList<>();
        ArrayList<Integer> resList=new ArrayList<>();
        resList.add(1);
        keyWordList=initMySQL.insertKeyword(cr,conn,keyWordList);
        assertEquals(keyWordList.get(0),resList.get(0));

    }

    @Test
    public void insertPublication() {
        int pubId=initMySQL.insertPublication(cr,conn,"ase");
        assertEquals(pubId,1);
    }

    @Test
    public void insertAtricle() {
        int articleId=initMySQL.insertAtricle(cr,conn,1);
        assertEquals(articleId,1);
    }


}