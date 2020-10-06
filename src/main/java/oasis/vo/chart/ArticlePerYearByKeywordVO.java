package oasis.vo.chart;

import java.util.List;

public class ArticlePerYearByKeywordVO {
    /**
     * @author cmw
     * @version 2.0
     * @date 2020/03/31 16.50
     * @description 某研究方向每年相关论文数量的VO类
     */
    private List<String> yearList;
    private List<Integer> articleNumList;

    public ArticlePerYearByKeywordVO(List<String> yearList, List<Integer> articleNumList) {
        this.yearList = yearList;
        this.articleNumList = articleNumList;
    }

    public List<String> getYearList() {
        return yearList;
    }

    public void setYearList(List<String> yearList) {
        this.yearList = yearList;
    }

    public List<Integer> getArticleNumList() {
        return articleNumList;
    }

    public void setArticleNumList(List<Integer> articleNumList) {
        this.articleNumList = articleNumList;
    }
}
