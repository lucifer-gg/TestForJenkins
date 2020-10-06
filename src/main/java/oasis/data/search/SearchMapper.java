package oasis.data.search;

import oasis.entity.ArticlePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/04 08:21
 */
@Repository
@Mapper
public interface SearchMapper {

    /**
     * 通过文章 ID 检索文章详细信息
     *
     * @param docId
     * @return
     */
    ArticlePO getArtDetailById(@Param("docId") int docId);

    /**
     * 获取所有文章的 ID
     *
     * @return
     */
    List<Integer> getAllDocId();

    /**
     * 通过作者列表获取文章 ID
     *
     * @param authorList
     * @return
     */
    List<Integer> getDocIdByAuthorList(@Param("authorList") String authorList);

    /**
     * 通过单一作者获取文章 ID
     *
     * @param author
     * @return
     */
    List<Integer> getDocIdByTheAuthor(@Param("author") String author);

    /**
     * 通过机构列表获取文章 ID
     *
     * @param affiliationList
     * @return
     */
    List<Integer> getDocIdByAffiliationList(@Param("affiliationList") String affiliationList);

    /**
     * 通过单一机构获取文章 ID
     *
     * @param affiliation
     * @return
     */
    List<Integer> getDocIdByTheAffiliation(@Param("affiliation") String affiliation);

    /**
     * 通过关键字列表获取文章 ID
     *
     * @param keyWordList
     * @return
     */
    List<Integer> getDocIdByKeyWordList(@Param("keyWordList") String keyWordList);

    /**
     * 通过单一关键字获取文章 ID
     *
     * @param keyWord
     * @return
     */
    List<Integer> getDocIdByTheKeyWord(@Param("keyWord") String keyWord);

    /**
     * 通过会议名称获取文章 ID
     *
     * @param publication
     * @return
     */
    List<Integer> getDocIdByPublicName(@Param("publication") String publication);

    /**
     * 通过会议年份获取文章 ID
     *
     * @param startTime
     * @param endTime
     * @return
     */
    List<Integer> getDocIdByPublicYear(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 增加关键字的搜索次数
     *
     * @param keyWord
     */
    void incKeyWordCount(@Param("keyWord") String keyWord);

    /**
     * 判断是否存在该文章
     *
     * @param docId
     * @return
     */
    Boolean hasTheArticle(@Param("docId") int docId);

    /**
     * 判断是否存在搜索表单中的作者
     *
     * @param authorList
     * @return
     */
    Boolean hasTheAuthor(@Param("authorList") String authorList);

    /**
     * 判断是否存在搜索表单中的机构
     *
     * @param affiliationList
     * @return
     */
    Boolean hasTheAffiliation(@Param("affiliationList") String affiliationList);

    /**
     * 判断是否存在搜索表单中的关键字
     *
     * @param keyWordList
     * @return
     */
    Boolean hasTheKeyWord(@Param("keyWordList") String keyWordList);

    /**
     * 判断是否存在搜索表单中的会议/期刊
     *
     * @param publication
     * @return
     */
    Boolean hasThePublication(@Param("publication") String publication);

    /**
     * 判断是否存在搜索表单中的会议/期刊
     *
     * @param startTime
     * @param endTime
     * @return
     */
    Boolean hasThePublicYear(@Param("startTime") String startTime, @Param("endTime") String endTime);

}
