package oasis.vo.entity;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/29 21:03
 * @description 检索所得的机构 VO 类
 */
public class AffiliationSearchedVO {

    /**
     * 机构编号
     */
    private int affiliationId;

    /**
     * 机构名称
     */
    private String affiliationName;

    /**
     * 下属作者数量
     */
    private int subAuthorNum;

    /**
     * 发表论文数量
     */
    private int totalArticle;

    /**
     * 引用总量
     */
    private int reference;

    public int getAffiliationId() {
        return affiliationId;
    }

    public void setAffiliationId(int affiliationId) {
        this.affiliationId = affiliationId;
    }

    public String getAffiliationName() {
        return affiliationName;
    }

    public void setAffiliationName(String affiliationName) {
        this.affiliationName = affiliationName;
    }

    public int getSubAuthorNum() {
        return subAuthorNum;
    }

    public void setSubAuthorNum(int subAuthorNum) {
        this.subAuthorNum = subAuthorNum;
    }

    public int getTotalArticle() {
        return totalArticle;
    }

    public void setTotalArticle(int totalArticle) {
        this.totalArticle = totalArticle;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public AffiliationSearchedVO() {
    }

    public AffiliationSearchedVO(int affiliationId, String affiliationName, int subAuthorNum, int totalArticle, int reference) {
        this.affiliationId = affiliationId;
        this.affiliationName = affiliationName;
        this.subAuthorNum = subAuthorNum;
        this.totalArticle = totalArticle;
        this.reference = reference;
    }

}
