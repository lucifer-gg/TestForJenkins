package oasis.entity.rank;

/**
 * @author L.T
 * @version 1.6
 * @date 2020/03/01 19:14
 * @description Top 作者信息 PO
 */
public class RankAuthorPO {

    /**
     * 作者姓名
     */
    private String authorName;

    /**
     * 作者 ID
     */
    private Integer authorId;

    /**
     * 该作者发表的论文数量
     */
    private Integer articleNum;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Integer articleNum) {
        this.articleNum = articleNum;
    }

    public RankAuthorPO() {
    }

    public RankAuthorPO(String authorName, Integer authorId, Integer articleNum) {
        this.authorName = authorName;
        this.authorId = authorId;
        this.articleNum = articleNum;
    }

}
