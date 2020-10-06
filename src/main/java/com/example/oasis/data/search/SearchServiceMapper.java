package com.example.oasis.data.search;

import com.example.oasis.vo.SearchResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface SearchServiceMapper {
    /**
     * 根据作者名字来搜索
     * @param author
     * @return
     */
     Integer[] searchByAuthor(@Param("author") String author);
    /**
     * 根据会议来搜索
     * @param meeting
     * @return
     */
    Integer[] searchByMeeting(@Param("meeting") String meeting);
    /**
     * 根据出版商来搜索
     * @param organ
     * @return
     */
     Integer[] searchByOrgan(@Param("organ") String organ);
    /**
     * 根据时间来搜索
     * @param startTime
     * @param endTime
     * @return
     */
     Integer[] searchByTime(@Param("startTime") Integer startTime,@Param("endTime") Integer endTime);
    /**
     * 根据标题的关键字来搜索
     * @param keyword
     * @return
     */
    Integer[] searchByKeyWord(@Param("keyword") String keyword);
    /**
     * 根据出版id获得所有需要的信息
     * @param publishId
     * @return
     */
    List<SearchResult> getResult(List<Integer> publishId);
    /**
     * 根据出版id获得所有作者信息
     * @param paperId
     * @return
     */
     String[] getAuthors(@Param("paperId") Integer paperId);
   int getAuthorsId(@Param("author") String author);
}
