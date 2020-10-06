package oasis.vo.entity;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/30 16:16
 * @description 机构画像 VO 类
 */
public class AffiliationPortraitVO {

    /**
     * 机构名称
     */
    private String affiliationName;

    /**
     * 下属作者数量
     */
    private Integer subAuthorNum;

    /**
     * 发表论文数量
     */
    private Integer articleNum;

    /**
     * 总引用数量
     */
    private Integer reference;

    /**
     * 活跃度
     */
    private Integer activation;

    /**
     * H-Index
     */
    private Integer hindex;

    public String getAffiliationName() {
        return affiliationName;
    }

    public void setAffiliationName(String affiliationName) {
        this.affiliationName = affiliationName;
    }

    public Integer getSubAuthorNum() {
        return subAuthorNum;
    }

    public void setSubAuthorNum(Integer subAuthorNum) {
        this.subAuthorNum = subAuthorNum;
    }

    public Integer getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Integer articleNum) {
        this.articleNum = articleNum;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public Integer getActivation() {
        return activation;
    }

    public void setActivation(Integer activation) {
        this.activation = activation;
    }

    public Integer getHindex() {
        return hindex;
    }

    public void setHindex(Integer hindex) {
        this.hindex = hindex;
    }

    public AffiliationPortraitVO() {
    }

    public AffiliationPortraitVO(String affiliationName, Integer subAuthorNum, Integer articleNum, Integer reference, Integer activation, Integer hindex) {
        this.affiliationName = affiliationName;
        this.subAuthorNum = subAuthorNum;
        this.articleNum = articleNum;
        this.reference = reference;
        this.activation = activation;
        this.hindex = hindex;
    }

}
