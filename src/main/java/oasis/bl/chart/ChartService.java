package oasis.bl.chart;

import oasis.vo.BasicResponse;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author cmw
 * @version 2.0
 * @date 2020/03/30 21.40
 */
public interface ChartService {
    /**
     * 获取某研究方向每年的论文数量
     *
     * @param keywordId
     * @return
     */

    BasicResponse getArticlePerYearByKeyword(int keywordId);

    /**
     * 查看某会议每年的文章总引用量
     *
     * @param publicationTitle
     * @return
     */
    BasicResponse getReferencePerYearByPublication(String publicationTitle);

    /**
     * 查看某会议每年的H-index
     *
     * @param publicationTitle
     * @return
     */
    BasicResponse getHindexPerYearByPublication(String publicationTitle);


    /**
     * 查看某会议每年发表的文章数量
     *
     * @param publicationTitle
     * @return
     */
    BasicResponse getArticlePerYearByPublication(String publicationTitle);

    /**
     * 查看某会议Top5的关键字
     *
     * @param publicationTitle
     * @return
     */

    BasicResponse getTopKeywordByPublication(String publicationTitle);


    /**
     * 查看某作者每年发表的文章数量
     *
     * @param authorId
     * @return
     */
    BasicResponse getAuthorAnnualArticle(int authorId);

    /**
     * 查看某机构每年发表的文章数量
     *
     * @param affiliationId
     * @return
     */
    BasicResponse getAffiliationAnnualArticle(int affiliationId);

    /**
     * 查看某机构研究方向的分布
     *
     * @param affiliationId
     * @return
     */
    BasicResponse getKeywordDistribution(int affiliationId);

    /**
     * 查看某机构每年的H-Index
     *
     * @param affiliationId
     * @return
     */
    BasicResponse getAffiliationAnnualHindex(int affiliationId);

    /**
     * 查看某研究方向每年的引用数量
     *
     * @param keywordId
     * @return
     */
    BasicResponse getRefPerYearBykeyword(int keywordId);

    /**
     * 查看某研究方向每年的H-Index
     *
     * @param keywordId
     * @return
     */
    BasicResponse getHindexPerYearByKeyword(int keywordId);


    /**
     * 获取作者每年的引用数
     *
     * @param authorId
     * @return
     */
    BasicResponse getReferencePerYearByAuthor(@RequestParam int authorId);

    /**
     * 获取作者链接图所需数据
     *
     * @param curAuthorId
     * @return
     */
    BasicResponse getLinkedDataByAuthor(int curAuthorId);

    /**
     * 获取全局作者链接图所需数据
     *
     * @return
     */
    BasicResponse getTotalAuthorLinkedData();

}
