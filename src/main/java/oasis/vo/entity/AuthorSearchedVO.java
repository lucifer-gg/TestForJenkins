package oasis.vo.entity;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/29 19:16
 * @description 检索所得的作者 VO 类
 */
public class AuthorSearchedVO {

    /**
     * 作者编号
     */
    private Integer authorId;

    /**
     * 作者姓名
     */
    private String authorName;

    /**
     * 所在机构
     */
    private String affiliation;

    /**
     * 文章引用总量
     */
    private Integer reference;

    /**
     * 作者 H-Index
     */
    private Integer hindex;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
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

    public AuthorSearchedVO() {
    }

    public AuthorSearchedVO(Integer authorId, String authorName, String affiliation, Integer reference, Integer hindex) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.affiliation = affiliation;
        this.reference = reference;
        this.hindex = hindex;
    }

}
