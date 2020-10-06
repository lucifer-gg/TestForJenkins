package com.example.oasis.blImpl.search;
import com.example.oasis.bl.search.SearchService;
import com.example.oasis.vo.ResponseVO;
import com.example.oasis.vo.SearchForm;
import com.example.oasis.vo.SearchResult;
import com.example.oasis.vo.Result;
import com.example.oasis.data.search.SearchServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SearchServiceImpl implements  SearchService{
    @Autowired
    private SearchServiceMapper searchServiceMapper;
    private static String REGEX_CHINESE = "[\u4e00-\u9fa5]";// 中文正则
    public  String testStr(String s) {

        // 去除中文
        Pattern pat = Pattern.compile(REGEX_CHINESE);
        Matcher mat = pat.matcher(s);
        return mat.replaceAll("");
    }
    @Override
    public ResponseVO search(SearchForm searchForm) {
        Integer[][] l1={{},{},{},{},{}};
        //设置各个字段来判断搜索内容
        boolean[] searchyes={false,false,false,false,false};
        int length;
        //获得各种传过来的数据，可能为空
        String author = searchForm.getAuthor();
        String meeting = searchForm.getMeeting();
        int startTime = searchForm.getStartTime();
        int endTime = searchForm.getEndTime();
        String organ = searchForm.getOrgan();
        String keyword = searchForm.getKeyword();
        Map<Integer, Integer> map = new TreeMap<>();
        //看各个字段如果不为空就可以进行搜索
        if (author != null&&author!="") {
            l1[0] = searchServiceMapper.searchByAuthor(author);
            searchyes[0]=true;
        }
        if (meeting != null&&meeting !="") {
            l1[1] = searchServiceMapper.searchByMeeting(meeting);
            searchyes[1]=true;
        }
        if (organ != null&&organ !="") {
            l1[2] = searchServiceMapper.searchByOrgan(organ);
            searchyes[2]=true;
        }
        if (startTime != 0) {
            if (endTime != 0)
                l1[3] = searchServiceMapper.searchByTime(startTime, endTime);
            else
                l1[3] = searchServiceMapper.searchByTime(startTime, startTime);
            searchyes[3]=true;
        }
        if (keyword != null&&keyword !="") {
            l1[4]= searchServiceMapper.searchByKeyWord(keyword);
            searchyes[4]=true;
        }
        //l中获得的文章id合并，并且去除重复
        int i = 0;
        Integer[] c={};
        for(;i<5;i++){
            if(searchyes[i]==true){
                c=l1[i];
                break;
            }
        }
        i++;
        for(;i<5;i++){
            if(searchyes[i]==true){
                c=getJ(c,l1[i]);
            }
        }
        for ( i = 0; i < c.length; i++) {
            map.put(c[i],c[i]);
        }
        i=0;
        Collection<Integer> values = map.values();
        Iterator<Integer> iterator = values.iterator();
        Integer c2 [] = new  Integer[values.size()];
        while (iterator.hasNext()){
            c2[i++] = iterator.next();
        }
        length = c2.length;
        //整合id
        SearchResult s=new SearchResult();
        List<Integer> ccc=new ArrayList<>();
        if(length==0)
            return ResponseVO.buildSuccess(new Result());
        for(int ii=0;ii<length;ii++)
            ccc.add(c2[ii]);
        //根据整合好的id来获得文章的信息
        try {
            List<SearchResult> results = new ArrayList<>();
            results=searchServiceMapper.getResult(ccc);
            length=results.size();
            for (i = 0; i < length; i++) {
                String[] authors=searchServiceMapper.getAuthors(results.get(i).getPaperid());
                if(authors.length!=0) {
                            for(int k=0;k<authors.length;k++){
                                s=results.get(i);
                                s.addauthor(testStr(authors[k]));
                                s.addauthorids(searchServiceMapper.getAuthorsId(authors[k]));
                            }
                            results.set(i, s);
                        }
                }
            //设置各种属性
            Result result=new Result();
            result.setSearchResult(results);
            result.setTotal(length);
            return ResponseVO.buildSuccess(result);

        } catch (Exception e) {
        return ResponseVO.buildFailure("搜索失败");
    }

    }


    private static Integer[] getJ(Integer[] m, Integer[] n)
    {
        List<Integer> rs = new ArrayList<Integer>();

        // 将较长的数组转换为set
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(m.length > n.length ? m : n));

        // 遍历较短的数组，实现最少循环
        for (Integer i : m.length > n.length ? n : m)
        {
            if (set.contains(i))
            {
                rs.add(i);
            }
        }

        Integer[] arr = {};
        return rs.toArray(arr);
    }
}
