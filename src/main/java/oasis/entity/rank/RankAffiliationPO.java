package oasis.entity.rank;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/04 15:34
 * @description Top 机构 PO
 */
public class RankAffiliationPO {

    /**
     * 机构名称
     */
    private String affiliationName;

    /**
     * 机构编号
     */
    private int affiliationId;

    /**
     * 机构发表论文的数量
     */
    private int articleNum;

    public String getAffiliationName() {
        return affiliationName;
    }

    public void setAffiliationName(String affiliationName) {
        this.affiliationName = affiliationName;
    }

    public int getAffiliationId() {
        return affiliationId;
    }

    public void setAffiliationId(int affiliationId) {
        this.affiliationId = affiliationId;
    }

    public int getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }

    public RankAffiliationPO() {
    }

    public RankAffiliationPO(String affiliationName, int affiliationId, int articleNum) {
        this.affiliationName = affiliationName;
        this.affiliationId = affiliationId;
        this.articleNum = articleNum;
    }

}
