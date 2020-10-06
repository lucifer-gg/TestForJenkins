package oasis.entity.rank;

public class RankAuthorByActivationPO {
    /**
     * @author cmw
     * @version 2.1
     * @date 2020/03/29 17:13
     * @description 根据活跃度排名的作者PO
     *
     */

    private String authorName;
    private int authorId;
    private int authorActivation;

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

    public int getAuthorActivation() {
        return authorActivation;
    }

    public void setAuthorActivation(int authorActivation) {
        this.authorActivation = authorActivation;
    }

    public RankAuthorByActivationPO(String authorName, int authorId, int authorActivation) {
        this.authorName = authorName;
        this.authorId = authorId;
        this.authorActivation = authorActivation;
    }
}
