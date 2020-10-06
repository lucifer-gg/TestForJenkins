package oasis.vo.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/04 08:26
 * @description 文章详细信息 VO 类
 */
public class ArticleDetailVO {

    /**
     * 文章编号
     */
    private Integer docId;

    /**
     * 文章标题
     */
    private String docTitle;

    /**
     * 文章摘要
     */
    private String docAbstract;

    /**
     * PDF链接
     */
    private String pdfLink;

    /**
     * 关键词
     */
    private List<String> keyWords;

    /**
     * 作者（们）
     */
    private List<Author> authors = new ArrayList<>();

    /**
     * 机构（们）【机构与作者一一对应】
     */
    private List<String> affiliation;

    /**
     * 会议/期刊信息名称
     */
    private String publicationTitle;

    /**
     * 会议/期刊时间（年份）
     */
    private String publicationTime;

    /**
     * 标识符
     */
    private String docIdentifier;

    /**
     * 页数
     */
    private Integer pageNum;

    /**
     * 开始页
     */
    private Integer startPage;

    /**
     * 结束页
     */
    private Integer endPage;

    /**
     * 文章被引用数
     */
    private Integer refs;

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public String getDocTitle() {
        return docTitle;
    }

    public void setDocTitle(String docTitle) {
        this.docTitle = docTitle;
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

    public List<String> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(List<String> keyWords) {
        this.keyWords = keyWords;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setAuthors(List<String> authorNames, List<Integer> authorIds) {
        Integer count = authorNames.size();
        for (int i = 0; i < count; i++) {
            Author author = new Author(authorNames.get(i), authorIds.get(i));
            this.authors.add(author);
        }
    }

    public List<String> getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(List<String> affiliation) {
        this.affiliation = affiliation;
    }

    public String getPublicationTitle() {
        return publicationTitle;
    }

    public void setPublicationTitle(String publicationTitle) {
        this.publicationTitle = publicationTitle;
    }

    public String getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(String publicationTime) {
        this.publicationTime = publicationTime;
    }

    public String getDocIdentifier() {
        return docIdentifier;
    }

    public void setDocIdentifier(String docIdentifier) {
        this.docIdentifier = docIdentifier;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getEndPage() {
        return endPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

    public Integer getRefs() {
        return refs;
    }

    public void setRefs(Integer refs) {
        this.refs = refs;
    }

    public ArticleDetailVO() {
    }

    public ArticleDetailVO(Integer docId, String docTitle, String docAbstract, String pdfLink, List<String> keyWords, List<String> authorNames, List<Integer> authorIds, List<String> affiliation, String publicationTitle, String publicationTime, String docIdentifier, Integer pageNum, Integer startPage, Integer endPage, Integer refs) {
        this.docId = docId;
        this.docTitle = docTitle;
        this.docAbstract = docAbstract;
        this.pdfLink = pdfLink;
        this.keyWords = keyWords;
        this.setAuthors(authorNames, authorIds);
        this.affiliation = affiliation;
        this.publicationTitle = publicationTitle;
        this.publicationTime = publicationTime;
        this.docIdentifier = docIdentifier;
        this.pageNum = pageNum;
        this.startPage = startPage;
        this.endPage = endPage;
        this.refs = refs;
    }

    private class Author {

        /**
         * 作者姓名
         */
        private String authorName;

        /**
         * 作者编号
         */
        private Integer authorId;

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public Integer getAuthorId() {
            return authorId;
        }

        public void setAuthorId(Integer authorId) {
            this.authorId = authorId;
        }

        public Author() {
        }

        public Author(String authorName, Integer authorId) {
            this.authorName = authorName;
            this.authorId = authorId;
        }

    }

    @Override
    public String toString() {
        return "ArticleDetailVO{" +
                "docId=" + docId +
                ", docTitle='" + docTitle + '\'' +
                ", docAbstract='" + docAbstract + '\'' +
                ", pdfLink='" + pdfLink + '\'' +
                ", keyWords=" + keyWords +
                ", authors=" + authors +
                ", affiliation=" + affiliation +
                ", publicationTitle='" + publicationTitle + '\'' +
                ", publicationTime='" + publicationTime + '\'' +
                ", docIdentifier='" + docIdentifier + '\'' +
                ", pageNum=" + pageNum +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", refs=" + refs +
                '}';
    }

}
