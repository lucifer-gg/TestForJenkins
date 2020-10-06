package oasis.vo.rank;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/06 15:03
 * @description 文章 VO 类
 */
public class ArticleVO {

    /**
     * 文章标题
     */
    private String docTitle;

    /**
     * 文章 ID
     */
    private Integer docId;

    /**
     * 文章被引用量
     */
    private Integer reference;

    public String getDocTitle() {
        return docTitle;
    }

    public void setDocTitle(String docTitle) {
        this.docTitle = docTitle;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public ArticleVO() {
    }

    public ArticleVO(String docTitle, Integer docId, Integer reference) {
        this.docTitle = docTitle;
        this.docId = docId;
        this.reference = reference;
    }

}
