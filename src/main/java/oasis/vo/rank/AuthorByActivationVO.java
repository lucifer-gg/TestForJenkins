package oasis.vo.rank;

public class AuthorByActivationVO {
    /**
     * @author cmw
     * @version 1.0
     * @date 2020/03/29 16.48
     * @description 包含活跃度的作者 VO 类
     */
    private String authorName;
    private int authorId;
    private int activation;

    public AuthorByActivationVO(String authorName, int authorId, int activation) {
        this.authorName = authorName;
        this.authorId = authorId;
        this.activation = activation;
    }

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

    public int getActivation() {
        return activation;
    }

    public void setActivation(int activation) {
        this.activation = activation;
    }
}
