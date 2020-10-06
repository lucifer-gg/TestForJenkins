package oasis.entity;

/**
 * @author L.T
 * @version 1.6
 * @date 2020/03/01 19:01
 * @description 文章 PO
 */
public class ArticlePO {

    /**
     * 文章编号
     */
    private int docId;

    /**
     * 文章标题
     */
    private String docTitle;

    /**
     * 会议/期刊信息编号
     */
    private int publicationId;

    /**
     * 开始页
     */
    private int startPage;

    /**
     * 结束页
     */
    private int endPage;

    /**
     * 文章摘要
     */
    private String docAbstract;

    /**
     * PDF 链接
     */
    private String pdfLink;

    /**
     * DOI
     */
    private String doi;

    /**
     * 文章被引用数
     */
    private int reference;

    /**
     * 引用论文数量
     */
    private int citation;

    /**
     * 出版商
     */
    private String publisher;

    /**
     * 标识符
     */
    private String docIdentifier;

    /**
     * 检索次数
     */
    private int searchCount;

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getDocTitle() {
        return docTitle;
    }

    public void setDocTitle(String docTitle) {
        this.docTitle = docTitle;
    }

    public int getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(int publicationId) {
        this.publicationId = publicationId;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public String getDocAbstract() {
        return docAbstract;
    }

    public void setDocAbstract(String docAbstract) {
        this.docAbstract = docAbstract;
    }

    public String getPdfLink() {
        return pdfLink;
    }

    public void setPdfLink(String pdfLink) {
        this.pdfLink = pdfLink;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public int getCitation() {
        return citation;
    }

    public void setCitation(int citation) {
        this.citation = citation;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDocIdentifier() {
        return docIdentifier;
    }

    public void setDocIdentifier(String docIdentifier) {
        this.docIdentifier = docIdentifier;
    }

    public int getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(int searchCount) {
        this.searchCount = searchCount;
    }

    public ArticlePO() {
    }

    public ArticlePO(int docId, String docTitle, int publicationId, int startPage, int endPage, String docAbstract, String pdfLink, String doi, int reference, int citation, String publisher, String docIdentifier, int searchCount) {
        this.docId = docId;
        this.docTitle = docTitle;
        this.publicationId = publicationId;
        this.startPage = startPage;
        this.endPage = endPage;
        this.docAbstract = docAbstract;
        this.pdfLink = pdfLink;
        this.doi = doi;
        this.reference = reference;
        this.citation = citation;
        this.publisher = publisher;
        this.docIdentifier = docIdentifier;
        this.searchCount = searchCount;
    }

}
