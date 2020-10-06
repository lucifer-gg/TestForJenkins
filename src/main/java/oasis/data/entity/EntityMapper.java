package oasis.data.entity;

import oasis.entity.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/29 19:11
 */
@Repository
@Mapper
public interface EntityMapper {

    /**
     * 检索作者【精确】
     *
     * @param authorName
     * @return
     */
    List<AuthorSearchedPO> smartSearchAuthor(@Param("authorName") String authorName);

    /**
     * 检索作者【模糊】
     *
     * @param authorName
     * @return
     */
    List<AuthorSearchedPO> blurSearchAuthor(@Param("authorName") String authorName);

    /**
     * 检索机构【精确】
     *
     * @param affiliationName
     * @return
     */
    List<AffiliationSearchedPO> smartSearchAffiliation(@Param("affiliationName") String affiliationName);

    /**
     * 检索机构【模糊】
     *
     * @param affiliationName
     * @return
     */
    List<AffiliationSearchedPO> blurSearchAffiliation(@Param("affiliationName") String affiliationName);

    /**
     * 检索会议
     *
     * @param publicationTitle
     * @return
     */
    List<PublicationSearchedPO> searchPublication(@Param("publicationTitle") String publicationTitle);

    /**
     * 检索研究方向【精确】
     *
     * @param keyword
     * @return
     */
    List<KeywordSearchedPO> smartSearchKeyword(@Param("keyword") String keyword);

    /**
     * 检索研究方向【模糊】
     *
     * @param keyword
     * @return
     */
    List<KeywordSearchedPO> blurSearchKeyword(@Param("keyword") String keyword);

    /**
     * 查看作者画像
     *
     * @param authorId
     * @return
     */
    AuthorPortraitPO authorPortrait(@Param("authorId") int authorId);

    /**
     * 查看机构画像
     *
     * @param affiliationId
     * @return
     */
    AffiliationPortraitPO affiliationPortrait(@Param("affiliationId") int affiliationId);

    /**
     * 查看会议画像
     *
     * @param publicationTitle
     * @return
     */
    Integer publicationPortrait(@Param("publicationTitle") String publicationTitle);

    /**
     * 查看研究方向画像
     *
     * @param keywordId
     * @return
     */
    KeywordPortraitPO keywordPortrait(@Param("keywordId") int keywordId);

    /**
     * 根据文章 ID 获取引用量
     *
     * @param articleId
     * @return
     */
    Integer getArticleReference(@Param("articleId") int articleId);

    /**
     * 查看某作者的相关作者推荐
     *
     * @param curAuthorId
     * @return
     */
    String recommendAuthors(@Param("curAuthorId") int curAuthorId);

    /**
     * 获取实体数量
     *
     * @return
     */
    EntitiesNumPO getEntitiesNum();

}
