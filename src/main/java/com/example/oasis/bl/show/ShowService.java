package com.example.oasis.bl.show;


import com.example.oasis.po.Author;
import com.example.oasis.po.Meeting;
import com.example.oasis.po.Paper;

import java.util.List;

public interface ShowService {
    /**
     * @描述 根据论文标题获取论文信息
     * @参数 [title]
     * @返回值 com.example.oasis.po.Paper
     * @创建人 Chen Hongyu
     */
    public Paper getPaperByTitle(String title);

    /**
     * @描述 根据作者姓名获取作者信息
     * @参数 [name]
     * @返回值 com.example.oasis.po.Author
     * @创建人 Chen Hongyu
     */
    public Author getAuthorByName(String name);
    /**
     *@描述  根据出版方获取会议信息
     *@参数  [publish]
     *@返回值  com.example.oasis.po.Meeting
     *@创建人  Chen Hongyu
     */
    public Meeting getMeeting(String publish);
    /**
     *@描述 获取论文排名信息
     *@参数  []
     *@返回值  java.util.List<com.example.oasis.po.Paper>
     *@创建人  Chen Hongyu
     */
    public List<Paper> getRankPaper();
    /**
     *@描述 获取作者排名信息
     *@参数  []
     *@返回值  java.util.List<com.example.oasis.po.Author>
     *@创建人  Chen Hongyu
     */
    public List<Author> getRankAuthor();


}
