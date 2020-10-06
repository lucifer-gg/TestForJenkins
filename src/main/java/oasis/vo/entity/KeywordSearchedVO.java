package oasis.vo.entity;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/29 21:55
 * @description 检索所得的研究方向 VO 类
 */
public class KeywordSearchedVO {

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

    public KeywordSearchedVO() {
    }

    public KeywordSearchedVO(Integer keywordId, String keyword, Integer searchTime) {
        this.keywordId = keywordId;
        this.keyword = keyword;
        this.searchTime = searchTime;
    }

}
