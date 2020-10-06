package oasis.vo.rank;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/04 15:17
 * @description 关键字 VO 类
 */
public class KeyWordsVO {

    /**
     * 关键字 ID
     */
    private Integer keyWordsId;

    /**
     * 关键字
     */
    private String keyWords;

    /**
     * 搜索次数
     */
    private Integer keyWordsSearchTime;

    public Integer getKeyWordsId() {
        return keyWordsId;
    }

    public void setKeyWordsId(Integer keyWordsId) {
        this.keyWordsId = keyWordsId;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public Integer getKeyWordsSearchTime() {
        return keyWordsSearchTime;
    }

    public void setKeyWordsSearchTime(Integer keyWordsSearchTime) {
        this.keyWordsSearchTime = keyWordsSearchTime;
    }

    public KeyWordsVO() {
    }

    public KeyWordsVO(Integer keyWordsId, String keyWords, Integer keyWordsSearchTime) {
        this.keyWordsId = keyWordsId;
        this.keyWords = keyWords;
        this.keyWordsSearchTime = keyWordsSearchTime;
    }

}
