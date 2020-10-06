package oasis.entity.entity;

import oasis.vo.entity.KeywordSearchedVO;

/**
 * @author L.T
 * @version 1.6
 * @date 2020/03/29 21:56
 * @description 检索所得研究方向信息 PO
 */
public class KeywordSearchedPO {

    /**
     * 关键字编号
     */
    private Integer keywordId;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 搜索次数
     */
    private Integer searchTime;

    public Integer getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(Integer keywordId) {
        this.keywordId = keywordId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Integer searchTime) {
        this.searchTime = searchTime;
    }

    public KeywordSearchedVO getKeywordSearchedVO() {
        return new KeywordSearchedVO(keywordId, keyword, searchTime);
    }

    public KeywordSearchedPO() {
    }

    public KeywordSearchedPO(Integer keywordId, String keyword, Integer searchTime) {
        this.keywordId = keywordId;
        this.keyword = keyword;
        this.searchTime = searchTime;
    }

}
