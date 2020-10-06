package com.example.oasis.data.Interface;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.oasis.vo.*;
import java.util.List;


@Mapper
public interface InterfaceServiceMapper {

    /**
     * 根据作者Id来搜索领域
     * @param authorId
     * @return
     */
     List<AuthorDomain> getAuthorDomain(@Param("authorId") int authorId);
    /**
     * 根据作者Id来搜索论文
     * @param authorId
     * @return
     */
     List<PaperSpot> getAuthorPaper(@Param("authorId") int authorId);

    /**
     * 根据论文Id来搜索信息
     * @param
     * @return
     */
    List<PaperInf> getInf(@Param("paperId") int paperId);
    /**
     * 根据论文Id来搜索spot
     * @param paperId
     * @return
     */
     List<PaperSpot> getPaperSpot(@Param("paperId") int paperId);
    /**
     * 根据spot来搜索相似文章
     * @param paperId1
     * @param paperId2
     *  @param spot
     * @return
     */
    List<PaperSpot> getOtherPaper(@Param("paperId1") int paperId1,@Param("paperId2") int paperId2,String spot);

    /**
     * 根据spot来搜索相似文章
     * @param paperId
     *  @param authorId
     * @return
     */
  List<PaperSpot> getPaperSpotByAuthor(@Param("paperId") int paperId,@Param("authorId") int authorId);
    /**
     * 获得作者活跃度
     * @param spot
     *  @param authorId
     * @return
     */
    double getAuthorHot(@Param("spot") String spot,@Param("authorId") int authorId);
    /**
     * 获得作者活跃度
     * @param spot
     * @return
     */
    int getSpotNum(@Param("spot") String spot);
    /**
     * 获得作者名字
     * @param authorId
     * @return
     */
    String getAuthorName(@Param("authorId") int authorId);
    /**
     * 获得作者id
     * @param paperId
     * @return
     */
    List<Integer> getAuthorId(@Param("paperId")int paperId);
    /**
     * 获得文章活跃度
     * @param paperId
     * @return
     */
    double getPaperHot (@Param("paperId")int paperId);
    /**
     * 获得文章活跃度排名
     * @param
     * @return
     */
    List<PaperRank> getPaperRank();
}
