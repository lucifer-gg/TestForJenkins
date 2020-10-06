package oasis.entity.entity;

import oasis.vo.entity.EntitiesNumVO;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/04/15 19:12
 * @description 作者数量 PO
 */
public class EntitiesNumPO {

    /**
     * 作者数量
     */
    private int authorNum;

    /**
     * 引用数量
     */
    private int referenceNum;

    /**
     * 机构数量
     */
    private int affiliationNum;

    /**
     * 论文数量
     */
    private int articleNum;

    public int getAuthorNum() {
        return authorNum;
    }

    public void setAuthorNum(int authorNum) {
        this.authorNum = authorNum;
    }

    public int getReferenceNum() {
        return referenceNum;
    }

    public void setReferenceNum(int referenceNum) {
        this.referenceNum = referenceNum;
    }

    public int getAffiliationNum() {
        return affiliationNum;
    }

    public void setAffiliationNum(int affiliationNum) {
        this.affiliationNum = affiliationNum;
    }

    public int getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }

    public EntitiesNumPO() {
    }

    public EntitiesNumPO(int authorNum, int referenceNum, int affiliationNum, int articleNum) {
        this.authorNum = authorNum;
        this.referenceNum = referenceNum;
        this.affiliationNum = affiliationNum;
        this.articleNum = articleNum;
    }

    public EntitiesNumVO getEntitiesNumVO() {
        return new EntitiesNumVO(this.authorNum, this.referenceNum, this.affiliationNum, this.articleNum);
    }

}
