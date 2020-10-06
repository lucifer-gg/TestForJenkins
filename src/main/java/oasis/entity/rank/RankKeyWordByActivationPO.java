package oasis.entity.rank;

public class RankKeyWordByActivationPO {

    /**
     * @author cmw
     * @version 2.1
     * @date 2020/03/29 16:37
     * @description 根据活跃度排名的关键字PO
     */


    private String keyWord;//关键字（研究方向）
    private int keyWordId;//关键字Id
    private int KeyWordActivation;//关键字活跃度

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public int getKeyWordId() {
        return keyWordId;
    }

    public void setKeyWordId(int keyWordId) {
        this.keyWordId = keyWordId;
    }

    public int getKeyWordActivation() {
        return KeyWordActivation;
    }

    public void setKeyWordActivation(int keyWordActivation) {
        KeyWordActivation = keyWordActivation;
    }

    public RankKeyWordByActivationPO(String keyWord, int keyWordId, int keyWordActivation) {
        this.keyWord = keyWord;
        this.keyWordId = keyWordId;
        KeyWordActivation = keyWordActivation;
    }
}
