package oasis.data.chart;

import oasis.entity.chart.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cmw
 * @version 2.0
 * @date 2020/03/30 21:46
 */
@Repository
@Mapper
public interface ChartMapper {

    /**
     * 根据会议名称获取每年的hindex
     *
     * @param publicationTitle
     * @return
     */
    List<HinderPerYearPO> getHindexPerYearByTitle(@Param("publicationTitle") String publicationTitle);

    /**
     * 查看每年发表的文章数量
     *
     * @param articleIds
     * @return
     */
    List<AnnualArticlePO> getAnnualArticles(@Param("articleIds") String articleIds);

    /**
     * 查看某机构研究方向的分布
     *
     * @param keywordIds
     * @return
     */
    List<KeywordDistPO> getKeywordDist(@Param("keywordIds") String keywordIds);

    /**
     * 查看某作者的链接作者编号
     *
     * @param curAuthorId
     * @return
     */
    List<Integer> getLinkedAuthors(@Param("curAuthorId") int curAuthorId);

    /**
     * 查看某作者与链接作者的合作次数
     *
     * @param curAuthorId
     * @return
     */
    List<Integer> getCoopCounts(@Param("curAuthorId") int curAuthorId);

    /**
     * 查看作者结点信息
     *
     * @param authorId
     * @return
     */
    AuthorNodePO getAuthorNodeInfo(int authorId);

}
