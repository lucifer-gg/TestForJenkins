package oasis.vo.entity;

/**
 * @author L.T
 * @version 1.1
 * @date 2020/03/30 17:41
 * @description 研究方向画像 VO 类
 */
public class KeywordPortraitVO {

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 相关论文总数
     */
    private Integer articleNum;

    /**
     * 总的引用次数
     */
    private Integer reference;

    /**
     * 活跃度
     */
    private Integer activation;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Integer articleNum) {
        this.articleNum = articleNum;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public Integer getActivation() {
        return activation;
    }

    public void setActivation(Integer activation) {
        this.activation = activation;
    }

    public KeywordPortraitVO() {
    }

    public KeywordPortraitVO(String keyword, Integer articleNum, Integer reference, Integer activation) {
        this.keyword = keyword;
        this.articleNum = articleNum;
        this.reference = reference;
        this.activation = activation;
    }

    @Override
    public String toString() {
        return "KeywordPortraitVO{" +
                "keyword='" + keyword + '\'' +
                ", articleNum=" + articleNum +
                ", reference=" + reference +
                ", activation=" + activation +
                '}';
    }

}
