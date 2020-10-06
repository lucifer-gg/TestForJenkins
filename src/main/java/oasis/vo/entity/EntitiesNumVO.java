package oasis.vo.entity;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/04/15 19:09
 * @description 实体数量 VO 类
 */
public class EntitiesNumVO {

    /**
     * 作者数量
     */
    private Integer authorNum;

    /**
     * 引用数量
     */
    private Integer referenceNum;

    /**
     * 机构数量
     */
    private Integer affiliationNum;

    /**
     * 论文数量
     */
    private Integer articleNum;

    public Integer getAuthorNum() {
        return authorNum;
    }

    public void setAuthorNum(Integer authorNum) {
        this.authorNum = authorNum;
    }

    public Integer getReferenceNum() {
        return referenceNum;
    }

    public void setReferenceNum(Integer referenceNum) {
        this.referenceNum = referenceNum;
    }

    public Integer getAffiliationNum() {
        return affiliationNum;
    }

    public void setAffiliationNum(Integer affiliationNum) {
        this.affiliationNum = affiliationNum;
    }

    public Integer getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Integer articleNum) {
        this.articleNum = articleNum;
    }

    public EntitiesNumVO() {
    }

    public EntitiesNumVO(Integer authorNum, Integer referenceNum, Integer affiliationNum, Integer articleNum) {
        this.authorNum = authorNum;
        this.referenceNum = referenceNum;
        this.affiliationNum = affiliationNum;
        this.articleNum = articleNum;
    }

    @Override
    public String toString() {
        return "EntitiesNumVO{" +
                "authorNum=" + authorNum +
                ", referenceNum=" + referenceNum +
                ", affiliationNum=" + affiliationNum +
                ", articleNum=" + articleNum +
                '}';
    }

}
