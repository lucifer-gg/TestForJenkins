package oasis.entity.chart;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/31 14:59
 * @description 每年发表的文章数量 PO
 */
public class AnnualArticlePO {

    /**
     * 发表年份
     */
    private String year;

    /**
     * 文章数量
     */
    private int articleNum;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }

    public AnnualArticlePO() {
    }

    public AnnualArticlePO(String year, int articleNum) {
        this.year = year;
        this.articleNum = articleNum;
    }

}
