package oasis.vo.entity;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/04/02 10:27
 * @description 机构下属作者信息 VO 类
 */
public class SubAuthorVO {

    /**
     * 作者姓名
     */
    private String authorName;

    /**
     * 作者编号
     */
    private Integer authorId;

    /**
     * 发表文章数量
     */
    private Integer articleNum;

    /**
     * 文章引用数量
     */
    private Integer reference;

    /**
     * H-Index
     */
    private Integer hindex;

    /**
     * 作者活跃度
     */
    private Integer activation;

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

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public Integer getHindex() {
        return hindex;
    }

    public void setHindex(Integer hindex) {
        this.hindex = hindex;
    }

    public Integer getActivation() {
        return activation;
    }

    public void setActivation(Integer activation) {
        this.activation = activation;
    }

    public SubAuthorVO() {
    }

    public SubAuthorVO(String authorName, Integer authorId, Integer articleNum, Integer reference, Integer hindex, Integer activation) {
        this.authorName = authorName;
        this.authorId = authorId;
        this.articleNum = articleNum;
        this.reference = reference;
        this.hindex = hindex;
        this.activation = activation;
    }

    @Override
    public String toString() {
        return "SubAuthorsVO{" +
                "authorName='" + authorName + '\'' +
                ", authorId=" + authorId +
                ", articleNum=" + articleNum +
                ", reference=" + reference +
                ", hindex=" + hindex +
                ", activation=" + activation +
                '}';
    }

}
