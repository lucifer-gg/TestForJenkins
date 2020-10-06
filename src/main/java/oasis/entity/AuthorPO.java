package oasis.entity;

/**
 * @author L.T
 * @version 1.6
 * @date 2020/03/01 19:14
 * @description 作者信息 PO
 */
public class AuthorPO {

    /**
     * 作者 ID
     */
    private int authorId;

    /**
     * 作者名字
     */
    private String authorName;

    /**
     * 所属机构 ID
     */
    private int affiliationId;

    /**
     * 检索次数
     */
    private int authorSearchCount;

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

    public int getAffiliationId() {
        return affiliationId;
    }

    public void setAffiliationId(int affiliationId) {
        this.affiliationId = affiliationId;
    }

    public int getAuthorSearchCount() {
        return authorSearchCount;
    }

    public void setAuthorSearchCount(int authorSearchCount) {
        this.authorSearchCount = authorSearchCount;
    }

    public AuthorPO() {
    }

    public AuthorPO(int authorId, String authorName, int affiliationId, int authorSearchCount) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.affiliationId = affiliationId;
        this.authorSearchCount = authorSearchCount;
    }

}
