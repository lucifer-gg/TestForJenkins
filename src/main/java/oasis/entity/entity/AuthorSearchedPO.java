package oasis.entity.entity;

/**
 * @author L.T
 * @version 1.6
 * @date 2020/03/29 19:36
 * @description 检索所得作者信息 PO
 */
public class AuthorSearchedPO {

    /**
     * 作者编号
     */
    private int authorId;

    /**
     * 作者姓名
     */
    private String authorName;

    /**
     * 所在机构
     */
    private String affiliation;

    /**
     * 作者 H-Index
     */
    private int hindex;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
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

    public int getHindex() {
        return hindex;
    }

    public void setHindex(int hindex) {
        this.hindex = hindex;
    }

    public AuthorSearchedPO() {
    }

    public AuthorSearchedPO(int authorId, String authorName, String affiliation, int hindex) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.affiliation = affiliation;
        this.hindex = hindex;
    }

}
