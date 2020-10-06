package com.example.oasis.data.update;




import com.example.oasis.po.Author;
import com.example.oasis.po.Meeting;
import com.example.oasis.po.Paper;
import com.example.oasis.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UpdateServiceMapper {
    /**
     *@描述 插入论文数据
     *@参数  [paper]
     *@返回值  void
     *@创建人  Chen Hongyu
     */
    public void  insertPaper(PaperVO paper);
    /**
     *@描述 插入作者数据
     *@参数  [author]
     *@返回值  void
     *@创建人  Chen Hongyu
     */
    public void insertAuthor(AuthorVO author);
    /**
     *@描述 插入出版关系数据
     *@参数  [publish]
     *@返回值  void
     *@创建人  Chen Hongyu
     */
    public void insertPublish(PublishVO publish);
    /**
     *@描述 插入会议数据
     *@参数  [meeting]
     *@返回值  void
     *@创建人  Chen Hongyu
     */
    public  void insertMeeting(MeetingVO meeting);
    /**
     *@描述 插入作者论文关系数据
     *@参数  [produce]
     *@返回值  void
     *@创建人  Chen Hongyu
     */
    public void insertProduce(ProduceVO produce);



    /**
     *@描述 根据论文标题获取论文信息
     *@参数  [Title]
     *@返回值  com.example.oasis.po.Paper
     *@创建人  Chen Hongyu
     */
    public Paper selectPaperByTitle(@Param("Title")String Title);
    /**
     *@描述 根据作者姓名获取作者信息
     *@参数  [Name]
     *@返回值  com.example.oasis.po.Author
     *@创建人  Chen Hongyu
     */
    public Author selectAuthorByName(@Param("Name")String Name);
    /**
     *@描述 根据出版方获取会议信息
     *@参数  [Publish]
     *@返回值  com.example.oasis.po.Meeting
     *@创建人  Chen Hongyu
     */
    public Meeting selectMeeting(@Param("Publish")String Publish);

}


