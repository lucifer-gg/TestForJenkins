package oasis.bl.entity;

import oasis.vo.BasicResponse;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/29 19:07
 */
public interface EntityService {

    /**
     * 检索作者
     *
     * @param authorName
     * @return
     */
    BasicResponse searchAuthor(String authorName);

    /**
     * 检索机构
     *
     * @param affiliationName
     * @return
     */
    BasicResponse searchAffiliation(String affiliationName);

    /**
     * 检索会议
     *
     * @param publicationTitle
     * @return
     */
    BasicResponse searchPublication(String publicationTitle);

    /**
     * 检索研究方向
     *
     * @param keyword
     * @return
     */
    BasicResponse searchKeyword(String keyword);


    /**
     * 查看作者画像
     *
     * @param authorId
     * @return
     */
    BasicResponse authorPortrait(int authorId);

    /**
     * 查看机构画像
     *
     * @param affiliationId
     * @return
     */
    BasicResponse affiliationPortrait(int affiliationId);

    /**
     * 查看会议画像
     *
     * @param publicationTitle
     * @return
     */
    BasicResponse publicationPortrait(String publicationTitle);

    /**
     * 查看研究方向画像
     *
     * @param keywordId
     * @return
     */
    BasicResponse keywordPortrait(int keywordId);

    /**
     * 获取相关作者推荐
     * @param authorId
     * @return
     */
    BasicResponse getRelatedAuthors(int authorId);

    /**
     * 查看某机构下属作者信息
     *
     * @param affiliationId
     * @return
     */
    BasicResponse getSubAuthorsByAffiliation(int affiliationId);

    /**
     * 查看某作者的相关作者推荐
     *
     * @param curAuthorId
     * @return
     */
    BasicResponse recommendAuthors(int curAuthorId);

    /**
     * 根据作者编号查看文章详情
     *
     * @param authorId
     * @return
     */
    BasicResponse getArticlesByAuthor(int authorId);

    /**
     * 根据关键字编号查看文章详情
     *
     * @param keywordId
     * @return
     */
    BasicResponse getArticlesByKeyword(int keywordId);

    /**
     * 获取各类实体的数目
     *
     * @return
     */
    BasicResponse getEntitiesNum();

}
