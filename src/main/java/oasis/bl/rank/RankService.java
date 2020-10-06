package oasis.bl.rank;

import oasis.vo.BasicResponse;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/04 14:18
 */
public interface RankService {

    /**
     * 获取论文数量前5的作者
     *
     * @return
     */
    BasicResponse getTopAuthors();

    /**
     * 获取被引用量前5的文章
     *
     * @return
     */
    BasicResponse getTopReferences();

    /**
     * 获取搜索次数前5的关键字
     *
     * @return
     */
    BasicResponse getTopKeyWords();

    /**
     * 获取 ASE 会议上发表论文数量前5的机构
     *
     * @return
     */
    BasicResponse getAseTopAffiliations();

    /**
     * 获取 ICSE 会议上发表论文数量前5的机构
     *
     * @return
     */
    BasicResponse getIcseTopAffiliations();


    /**
     * @author cmw
     * @version 2.0
     * @date 2020/03/29 17:18
     */

    /**
     * 获取活跃度排名前十的关键字
     *
     * @return
     */
    BasicResponse getTopKeyWordByActivation();

    /**
     * 获取活跃度排名前十的作者
     *
     * @return
     */
    BasicResponse getTopAuthorByActivation();


    /**
     * 获取活跃度排名前十的机构
     *
     * @return
     */
    BasicResponse getTopAffiliationByActivation();

    /**
     * 获取某研究方向排名前十的作者
     *
     * @return
     */
    BasicResponse getTopAuthorByKeyword(int keywordId);

    /**
     * 获取某研究方向排名前十的机构
     *
     * @return
     */
    BasicResponse getTopAffilicationByKeyword(int keywordId);


    /**
     * 热点趋势分析
     *
     * @return
     */
    BasicResponse analysisTopKeyword();

}
