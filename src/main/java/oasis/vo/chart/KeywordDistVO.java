package oasis.vo.chart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/31 16:48
 * @description 机构研究方向的分布 VO 类
 */
public class KeywordDistVO {

    /**
     * 研究方向列表
     */
    private List<String> keywordList = new ArrayList<>();

    /**
     * 文章数量列表
     */
    private List<Integer> articleNumList = new ArrayList<>();

    /**
     * 比例列表
     */
    private List<String> percentList = new ArrayList<>();

    public List<String> getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(List<String> keywordList) {
        this.keywordList = keywordList;
    }

    public void addKeywordList(String keyword) {
        this.keywordList.add(keyword);
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

    public List<String> getPercentList() {
        return percentList;
    }

    public void setPercentList(List<String> percentList) {
        this.percentList = percentList;
    }

    public void addPercentList(String percent) {
        this.percentList.add(percent);
    }

    public KeywordDistVO() {
    }

    public KeywordDistVO(List<String> keywordList, List<Integer> articleNumList, List<String> percentList) {
        this.keywordList = keywordList;
        this.articleNumList = articleNumList;
        this.percentList = percentList;
    }

}
