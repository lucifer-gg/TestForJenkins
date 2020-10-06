package oasis.entity.rank;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/04 14:59
 * @description Top 论文信息 PO
 */
public class RankArticlePO {

    /**
     * 文章标题
     */
    private String docTitle;

    /**
     * 文章 ID
     */
    private int docId;

    /**
     * 文章被引用量
     */
    private int reference;

    public String getDocTitle() {
        return docTitle;
    }

    public void setDocTitle(String docTitle) {
        this.docTitle = docTitle;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public RankArticlePO() {
    }

    public RankArticlePO(String docTitle, int docId, int reference) {
        this.docTitle = docTitle;
        this.docId = docId;
        this.reference = reference;
    }

}
