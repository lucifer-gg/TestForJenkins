package oasis.vo.chart;

import java.util.List;

/**
 * @author cmw
 * @version 2.0
 * @date 2020/03/31 16.50
 * @description 查看某会议每年发表的文章数量
 */
public class ArticlePerYearByPublicationVO {
    private List<String> yearList;
    private List<Integer> articleNumList;

    public ArticlePerYearByPublicationVO(List<String> yearList, List<Integer> articleNumList) {
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
