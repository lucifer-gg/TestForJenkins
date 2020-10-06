package oasis.vo.rank;

public class AuthorByKeywordVO {
    /**
     * @author cmw
     * @version 2.0
     * @date 2020/03/30 19.48
     * @description 描述研究方向相关的作者VO 类
     */
    private int authorId;
    private String authorName;

    public AuthorByKeywordVO(int authorId, String authorName) {
        this.authorId = authorId;
        this.authorName = authorName;
    }

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
}
