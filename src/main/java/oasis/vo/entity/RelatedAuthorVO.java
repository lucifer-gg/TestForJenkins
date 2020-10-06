package oasis.vo.entity;

/**
 * @author L.T
 * @version 1.1
 * @date 2020/04/05 00:32
 * @description 推荐作者 VO 类
 */
public class RelatedAuthorVO {

    /**
     * 作者姓名
     */
    private String authorName;

    /**
     * 作者编号
     */
    private Integer authorId;

    /**
     * 文章数量
     */
    private Integer articleNum;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Integer getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Integer articleNum) {
        this.articleNum = articleNum;
    }

    public RelatedAuthorVO() {
    }

    public RelatedAuthorVO(String authorName, Integer authorId, Integer articleNum) {
        this.authorName = authorName;
        this.authorId = authorId;
        this.articleNum = articleNum;
    }

    @Override
    public String toString() {
        return "RelatedAuthorVO{" +
                "authorName='" + authorName + '\'' +
                ", authorId=" + authorId +
                ", articleNum='" + articleNum + '\'' +
                '}';
    }

}
