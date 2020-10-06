package com.example.oasis.blImpl.search;

import com.example.oasis.vo.SearchForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
//由于无法对检索进行详细匹配，需要观察控制台输出来判断检索是否成功
public class SearchServiceImplTest {
    @Autowired
    private SearchServiceImpl searchService;
    @Test
    public void testsearchAuthor(){
        //论文只有一个作者的测试
        SearchForm searchForm=new SearchForm();
        searchForm.setAuthor("A. Ghanbari");
        searchService.search(searchForm);


    }
    @Test
    public void testsearchAuthors(){
        //论文有多个的作者的测试
        SearchForm searchForm=new SearchForm();
        searchForm.setAuthor("Y. Wang");
        searchService.search(searchForm);


    }
    /*  @Test
      public void testsearchMeeting(){
          //论文会议匹配 都是IE会议 不测试
          SearchForm searchForm=new SearchForm();
          searchForm.setMeeting("IEEE Conferences");
          searchService.search(searchForm);


      }*/
    // @Test
   /* public void testsearchOrgan(){
        //论文出版商测试 几乎都是IEEE 不测试
        SearchForm searchForm=new SearchForm();
        searchForm.setOrgan("IEEE");
         searchService.search(searchForm);


    }*/
    @Test
    public void testsearchTime(){
        //论文具体年份测试
        SearchForm searchForm=new SearchForm();
        searchForm.setStartTime(2015);
        searchService.search(searchForm);


    }
    @Test
    public void testsearchTimes(){
        //论文年份区间测试
        SearchForm searchForm=new SearchForm();
        searchForm.setStartTime(2018);
        searchForm.setEndTime(2020);
        searchForm.setKeyword("Error");
        searchService.search(searchForm);


    }
    @Test
    public void testsearchKeyWord(){
        //论文出版标题关键字匹配
        SearchForm searchForm=new SearchForm();
        searchForm.setKeyword("Error");
        searchService.search(searchForm);


    }
    @Test
    public void testsearchKeyWord2(){
        //论文出版标题关键字匹配
        SearchForm searchForm=new SearchForm();
        searchForm.setKeyword("test2");
        searchService.search(searchForm);


    }
}
