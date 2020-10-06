package oasis.entity.rank;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/04 15:14
 * @description Top 关键字 VO
 */
public class RankKeyWordPO {

    /**
     * 关键字 ID
     */
    private int keyWordsId;

    /**
     * 关键字
     */
    private String keyWords;

    /**
     * 搜索次数
     */
    private int keyWordsSearchTime;

    public int getKeyWordsId() {
        return keyWordsId;
    }

    public void setKeyWordsId(int keyWordsId) {
        this.keyWordsId = keyWordsId;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public int getKeyWordsSearchTime() {
        return keyWordsSearchTime;
    }

    public void setKeyWordsSearchTime(int keyWordsSearchTime) {
        this.keyWordsSearchTime = keyWordsSearchTime;
    }

    public RankKeyWordPO() {
    }

    public RankKeyWordPO(int keyWordsId, String keyWords, int keyWordsSearchTime) {
        this.keyWordsId = keyWordsId;
        this.keyWords = keyWords;
        this.keyWordsSearchTime = keyWordsSearchTime;
    }

}
