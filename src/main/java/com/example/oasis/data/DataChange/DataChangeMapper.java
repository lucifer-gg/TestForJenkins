package com.example.oasis.data.DataChange;
import com.example.oasis.po.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.oasis.vo.PaperInterfaceGet;
import com.example.oasis.vo.*;
import java.util.List;


@Mapper
public interface DataChangeMapper {
    /**
     * 抽取作者Domian需要的数据
     * @param
     * @return
     */
List<AuthorChangeOne> getAuthor();

    /**
     * 插入作者Domian数据
     * @param
     * @return
     */
void insertAuthorDomain(AuthorDomain authorDomain);
    /**
     * 抽取文章需要的数据
     * @param
     * @return
     */
List<AuthorChangeTwo> getPaperSpot();
    /**
     * 插入文章热点数据
     * @param
     * @return
     */
void insertPaperSpot(PaperSpot paperSpot);
    /**
     * 抽取文章需要的数据
     * @param
     * @return
     */
List<PaperChange> getPaperInf();
    /**
     * 插入文章数据
     * @param
     * @return
     */

void insertPaperInf(PaperInf paperInf);
    /**
     * 获得所有领域
     * @param
     * @return
     */
    List<AuthorDomain> getAllAuthorDomain();
    /**
     * 获得作者此领域文章数量
     * @param authorId
     * @param spot
     * @return
     */
    int getPaperNum(@Param("authorId") int authorId,@Param("spot") String spot);
    /**
     * 获得作者此领域文章发表时间
     * @param spot
     * @return
     */
    int getPapers(@Param("spot") String spot);
    /**
     * 插入活跃度
     * @param
     * @return
     */
    void insertHot(AuthorHot authorHot);
    /**
     * 获得所有id
     * @param
     * @return
     */
    List<PAForm> findAuthorIds();
    /**
     * 获得两人合作的次数
     * @param authorId1
     * @param authorId2
     * @return
     */
    int CollaborateCount(@Param("authorId1") int authorId1,@Param("authorId2") int authorId2);
    /**
     * 获得合作信息
     * @param authorId1
     * @param authorId2
     * @return
     */
    CollaborateChange getCollaborateInf(@Param("authorId1") int authorId1,@Param("authorId2") int authorId2);
    /**
     * 插入合作信息
     * @return
     */
    void insertCollaborateInf(CollaborateChange collaborateChange);

    /**
     * 查找合作信息
     *  @param authorId1
     *  @param authorId2
     * @return
     */
    int findCollaboration(@Param("authorId1") int authorId1,@Param("authorId2") int authorId2);
    /**
     * 更新合作信息
     *  @param authorId1
     *  @param authorId2
     * @return
     */
    void updateCollaboration(@Param("authorId1") int authorId1,@Param("authorId2") int authorId2);
    /**
     * 抽取文章活跃度需要的信息
     * @param
     * @return
     */
    List<paperHotInf> getPaperHotInf();
    /**
     * 抽取文章作者数目
     * @param paperId
     * @return
     */
    int getAuthorNum(@Param("paperId") int paperId);
    /**
     * 插入文章活跃度
     * @param
     * @return
     */
    void insertPaperHot(paperHot paperhot);
}
