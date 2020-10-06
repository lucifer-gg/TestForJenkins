package oasis.entity.chart;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/31 16:51
 * @description 机构研究方向的分布 PO
 */
public class KeywordDistPO {

    /**
     * 研究方向
     */
    private String keyword;

    /**
     * 文章数量
     */
    private int articleNum;

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

    public KeywordDistPO() {
    }

    public KeywordDistPO(String keyword, int articleNum) {
        this.keyword = keyword;
        this.articleNum = articleNum;
    }

}
