package oasis.entity.entity;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/04/02 10:14
 * @description 机构下属作者信息 PO
 */
public class SubAuthorPO {

    /**
     * 作者姓名
     */
    private String authorName;

    /**
     * 作者编号
     */
    private int authorId;

    /**
     * H-Index
     */
    private int hindex;

    /**
     * 作者活跃度
     */
    private int activation;

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

    public int getHindex() {
        return hindex;
    }

    public void setHindex(int hindex) {
        this.hindex = hindex;
    }

    public int getActivation() {
        return activation;
    }

    public void setActivation(int activation) {
        this.activation = activation;
    }

    public SubAuthorPO() {
    }

    public SubAuthorPO(String authorName, int authorId, int hindex, int activation) {
        this.authorName = authorName;
        this.authorId = authorId;
        this.hindex = hindex;
        this.activation = activation;
    }

}
