package oasis.data.mapping;

import oasis.entity.entity.SubAuthorPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/06 08:53
 */
@Repository
@Mapper
public interface MappingMapper {

    /**
     * 根据文章编号检索关键字编号列表
     *
     * @param docId
     * @return
     */
    List<Integer> getKeyWordsIdList(@Param("docId") int docId);

    /**
     * 根据文章编号检索作者编号列表
     *
     * @param docId
     * @return
     */
    List<Integer> getAuthorsIdList(@Param("docId") int docId);

    /**
     * 根据文章编号检索机构编号列表
     *
     * @param docId
     * @return
     */
    List<Integer> getAffiliationIdList(@Param("docId") int docId);

    /**
     * 根据作者编号检索文章编号
     *
     * @param authorId
     * @return
     */
    List<Integer> getArtIdByAuthorId(@Param("authorId") int authorId);

    /**
     * 根据机构编号检索文章编号
     *
     * @param affiliationId
     * @return
     */
    List<Integer> getArtIdByAffiliationId(@Param("affiliationId") int affiliationId);

    /**
     * 根据关键字编号检索文章编号
     *
     * @param keywordId
     * @return
     */
    List<Integer> getArtIdByKeywordId(@Param("keywordId") int keywordId);

    /**
     * 根据会议编号检索文章编号
     *
     * @param publicationId
     * @return
     */
    List<Integer> getArtIdByPublicationId(@Param("publicationId") int publicationId);

    /**
     * 根据关键字编号获取关键字
     *
     * @param keyWordId
     * @return
     */
    String getKeyWordById(@Param("keyWordId") int keyWordId);

    /**
     * 根据作者编号获取作者姓名
     *
     * @param authorId
     * @return
     */
    String getAuthorById(@Param("authorId") int authorId);

    /**
     * 根据机构编号获取机构名称
     *
     * @param affiliationId
     * @return
     */
    String getAffiliationById(@Param("affiliationId") int affiliationId);

    /**
     * 根据会议/期刊信息编号获取其名称
     *
     * @param publicationId
     * @return
     */
    String getPublicationTitleById(@Param("publicationId") int publicationId);

    /**
     * 根据会议/期刊信息编号获取其年份
     *
     * @param publicationId
     * @return
     */
    String getPublicationYearById(@Param("publicationId") int publicationId);

    /**
     * 根据机构编号获取其下属作者数量
     *
     * @param affiliationId
     * @return
     */
    Integer getSubAuthorNum(@Param("affiliationId") int affiliationId);

    /**
     * 根据关键字名获取关键字编号
     *
     * @param keyword
     * @return
     */
    Integer getKeyWordIdByName(@Param("keyword") String keyword);

    /**
     * 根据会议名称获取编号
     *
     * @param publicationName
     * @return
     */

    Integer getPublicationIdByName(@Param("publicationName") String publicationName);

    /**
     * 根据会议类型获取编号列表
     *
     * @param publicationTitle
     * @return
     */

    List<Integer> getPublicationIdsByType(@Param("publicationTitle") String publicationTitle);

    /**
     * 根据机构名称获取机构编号
     *
     * @param affiliationName
     * @return
     */

    Integer getAffiliationIdByName(@Param("affiliationName") String affiliationName);

    /**
     * 获取文章列表中属于 ASE 的数量
     *
     * @param sqlList
     * @return
     */
    Integer getAseNum(@Param("sqlList") String sqlList);

    /**
     * 获取文章列表中属于 ICSE 的数量
     *
     * @param sqlList
     * @return
     */
    Integer getIcseNum(@Param("sqlList") String sqlList);

    /**
     * 根据文章编号获取其发表年份
     *
     * @param docId
     * @return
     */
    String getDocYearByDocId(@Param("docId") int docId);

    /**
     * 根据论文编号获取其引用数
     *
     * @param docId
     * @return
     */
    Integer getReferenceByDocId(@Param("docId") int docId);

    /**
     * 获取某年的文章引用数量列表
     *
     * @param year
     * @return
     */
    List<Integer> getReferenceByYear(@Param("year") String year);

    /**
     * 根据机构编号获取其下属作者信息
     *
     * @param affiliationId
     * @return
     */
    List<SubAuthorPO> getSubAuthors(@Param("affiliationId") int affiliationId);

    /**
     * 根据关键字和年份获取文章列表
     *
     * @param keyword
     * @param year
     * @return
     */
    List<Integer> getDocIdListByKeywordAndYear(@Param("keyword") String keyword, @Param("year") String year);

    /**
     * 获取所有的年份列表
     *
     * @return
     */
    List<String> getYearList();

    /**
     * 获取所有的作者编号列表
     *
     * @return
     */
    List<Integer> getAllAuthorIds();

    /**
     * 根据年份获取机构的引用数量
     *
     * @param year
     * @param articleId
     * @return
     */
    Integer getAffiliationAnnualRef(@Param("year") String year, @Param("articleId") int articleId);

}
