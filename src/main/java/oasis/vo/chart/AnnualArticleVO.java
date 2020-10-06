package oasis.vo.chart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author L.T
 * @version 1.1
 * @date 2020/03/31 14:53
 * @description 每年发表的文章数量 VO 类
 */
public class AnnualArticleVO {

    /**
     * 年份列表
     */
    private List<String> yearList = new ArrayList<>();

    /**
     * 文章数量列表
     */
    private List<Integer> articleNumList = new ArrayList<>();

    public List<String> getYearList() {
        return yearList;
    }

    public void setYearList(List<String> yearList) {
        this.yearList = yearList;
    }

    public void addYearList(String year) {
        this.yearList.add(year);
    }

    public List<Integer> getArticleNumList() {
        return articleNumList;
    }

    public void setArticleNumList(List<Integer> articleNumList) {
        this.articleNumList = articleNumList;
    }

    public void addArticleNumList(Integer articleNum) {
        this.articleNumList.add(articleNum);
    }

    public void setArticleNum(String year, Integer articleNum) {
        int index = this.yearList.indexOf(year);
        this.articleNumList.set(index, articleNum);
    }

    public AnnualArticleVO() {
    }

    public AnnualArticleVO(List<String> yearList, List<Integer> articleNumList) {
        this.yearList = yearList;
        this.articleNumList = articleNumList;
    }

    @Override
    public String toString() {
        return "AnnualArticleVO{" +
                "yearList=" + yearList +
                ", articleNumList=" + articleNumList +
                '}';
    }

}
