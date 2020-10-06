package oasis.data.rank;

import oasis.entity.rank.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/04 14:22
 */
@Repository
@Mapper
public interface RankMapper {

    /**
     * 获取论文数量前5的作者
     *
     * @return
     */
    List<RankAuthorPO> getTopAuthors();

    /**
     * 获取被引用量前5的文章
     *
     * @return
     */
    List<RankArticlePO> getTopReferences();

    /**
     * 获取搜索次数前5的关键字
     *
     * @return
     */
    List<RankKeyWordPO> getTopKeyWords();

    /**
     * 获取 ASE 会议上发表论文数量前5的机构
     *
     * @return
     */
    List<RankAffiliationPO> getAseTopAffiliations();

    /**
     * 获取 ICSE 会议上发表论文数量前5的机构
     *
     * @return
     */
    List<RankAffiliationPO> getIcseTopAffiliations();

    /**
     * 根据活跃度获取前十的关键字（研究方向）
     *
     * @return
     * @author cmw
     */

    List<RankKeyWordByActivationPO> getTopKeyWordByActivation();

    /**
     * 根据活跃度获取前十的作者
     *
     * @return
     * @author cmw
     */
    List<RankAuthorByActivationPO> getTopAuthorByActivation();

    /**
     * 根据活跃度获取前十的机构
     *
     * @return
     * @author cmw
     */
    List<RankAffiliationByActivationPO> getTopAffiliationByActivation();

    /**
     * 获取热点趋势
     *
     * @return
     */
    List<HotTrendPO> getHotTrends();

}
