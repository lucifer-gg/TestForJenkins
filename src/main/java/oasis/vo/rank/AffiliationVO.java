package oasis.vo.rank;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/04 15:39
 * @description 机构 VO 类
 */
public class AffiliationVO {

    /**
     * 机构名称
     */
    private String affiliationName;

    /**
     * 机构编号
     */
    private Integer affiliationId;

    /**
     * 机构发表论文的数量
     */
    private Integer articleNum;

    public String getAffiliationName() {
        return affiliationName;
    }

    public void setAffiliationName(String affiliationName) {
        this.affiliationName = affiliationName;
    }

    public Integer getAffiliationId() {
        return affiliationId;
    }

    public void setAffiliationId(Integer affiliationId) {
        this.affiliationId = affiliationId;
    }

    public Integer getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Integer articleNum) {
        this.articleNum = articleNum;
    }

    public AffiliationVO() {
    }

    public AffiliationVO(String affiliationName, Integer affiliationId, Integer articleNum) {
        this.affiliationName = affiliationName;
        this.affiliationId = affiliationId;
        this.articleNum = articleNum;
    }

}
