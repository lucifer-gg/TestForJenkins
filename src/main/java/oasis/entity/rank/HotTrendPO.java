package oasis.entity.rank;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/04/14 23:59
 * @description 热点趋势 PO
 */
public class HotTrendPO {

    /**
     * 关键字名称
     */
    private String keyword;

    /**
     * 关键字编号
     */
    private int keywordId;

    /**
     * 关键字对应的文章数量
     */
    private int articleNum;

    /**
     * 关键字活跃度
     */
    private int activation;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(int keywordId) {
        this.keywordId = keywordId;
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

    public HotTrendPO() {
    }

    public HotTrendPO(String keyword, int keywordId, int articleNum, int activation) {
        this.keyword = keyword;
        this.keywordId = keywordId;
        this.articleNum = articleNum;
        this.activation = activation;
    }

}
