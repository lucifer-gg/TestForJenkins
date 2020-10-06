package com.example.oasis.data.show;

import com.example.oasis.po.Author;
import com.example.oasis.po.Meeting;
import com.example.oasis.po.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ShowServiceMapper {
    /**
     *@描述 根据论文标题搜索论文
     *@参数  [Title]
     *@返回值  com.example.oasis.po.Paper
     *@创建人  Chen Hongyu
     */
    public Paper selectPaperByTitle(@Param("Title")String Title);
    /**
     *@描述 根据作者姓名搜索作者
     *@参数  [Name]
     *@返回值  com.example.oasis.po.Author
     *@创建人  Chen Hongyu
     */
    public Author selectAuthorByName(@Param("Name")String Name);
    /**
     *@描述 根据出版方搜索会议
     *@参数  [Publish]
     *@返回值  com.example.oasis.po.Meeting
     *@创建人  Chen Hongyu
     */
    public Meeting selectMeeting(@Param("Publish")String Publish);
    /**
     *@描述 对论文排名
     *@参数  []
     *@返回值  java.util.List<com.example.oasis.po.Paper>
     *@创建人  Chen Hongyu
     */
    public List<Paper> selectRankPaper();

    /**
     *@描述 对作者排名
     *@参数  []
     *@返回值  java.util.List<com.example.oasis.po.Author>
     *@创建人  Chen Hongyu
     */
    public List<Author> selectRankAuthor();
    /**
     *@描述 根据作者id获取作者发表论文数
     *@参数  [author_id]
     *@返回值  int
     *@创建人  Chen Hongyu
     */
    public  int getPaperNum(@Param("author_id")int author_id);
    /**
     *@描述 根据论文id获取论文作者
     *@参数  [paper_id]
     *@返回值  java.util.List<java.lang.String>
     *@创建人  Chen Hongyu
     */
    public List<String> getPaperAuthor(@Param("paper_id")int paper_id);


}
