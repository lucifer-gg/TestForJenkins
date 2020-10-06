package oasis.vo.rank;

/**
 * @author cmw
 * @version 1.0
 * @date 2020/03/29 16.46
 * @description 包含活跃度的关键字 VO 类
 */
public class KeyWordByActivationVO {
    private String keyword;
    private int keywordId;
    private  int keywordActivation;

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

    public int getKeywordActivation() {
        return keywordActivation;
    }

    public void setKeywordActivation(int keywordActivation) {
        this.keywordActivation = keywordActivation;
    }

    public KeyWordByActivationVO(String keyword, int keywordId, int keywordActivation) {
        this.keyword = keyword;
        this.keywordId = keywordId;
        this.keywordActivation = keywordActivation;
    }
}
