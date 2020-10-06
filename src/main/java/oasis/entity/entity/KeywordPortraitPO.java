package oasis.entity.entity;

import oasis.vo.entity.KeywordPortraitVO;

/**
 * @author L.T
 * @version 1.2
 * @date 2020/03/30 17:50
 * @description 研究方向画像 PO
 */
public class KeywordPortraitPO {

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 相关论文总数
     */
    private int articleNum;

    /**
     * 活跃度
     */
    private int activation;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }

    public int getActivation() {
        return activation;
    }

    public void setActivation(int activation) {
        this.activation = activation;
    }

    public KeywordPortraitPO() {
    }

    public KeywordPortraitPO(String keyword, int articleNum, int activation) {
        this.keyword = keyword;
        this.articleNum = articleNum;
        this.activation = activation;
    }

}
