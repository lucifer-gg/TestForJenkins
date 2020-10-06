package oasis.entity;

/**
 * @author L.T
 * @version 1.6
 * @date 2020/03/01 19:22
 * @description 关键字信息 PO
 */
public class KeyWordsPO {

    /**
     * 关键字 ID
     */
    private int keyWordsId;

    /**
     * 关键字
     */
    private String keyWords;

    /**
     * 关键字检索次数
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

    public KeyWordsPO() {
    }

    public KeyWordsPO(int keyWordsId, String keyWords, int keyWordsSearchTime) {
        this.keyWordsId = keyWordsId;
        this.keyWords = keyWords;
        this.keyWordsSearchTime = keyWordsSearchTime;
    }

}
