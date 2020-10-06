package oasis.vo.rank;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/04 14:26
 * @description 作者 VO 类
 */
public class AuthorVO {

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

    public AuthorVO() {
    }

    public AuthorVO(String authorName, Integer authorId, Integer articleNum) {
        this.authorName = authorName;
        this.authorId = authorId;
        this.articleNum = articleNum;
    }

    @Override
    public String toString() {
        return "AuthorVO{" +
                "authorName='" + authorName + '\'' +
                ", authorId=" + authorId +
                ", articleNum=" + articleNum +
                '}';
    }

}
