package oasis.vo.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/04 08:26
 * @description 文章条目 VO 类
 */
public class ArticleItemVO {

    /**
     * 文章编号
     */
    private Integer articleId;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 机构名称
     */
    private List<String> affiliations;

    /**
     * 作者（们）
     */
    private List<Author> authors = new ArrayList<>();

    /**
     * 会议/期刊信息名称
     */
    private String publicationTitle;

    /**
     * 摘要
     */
    private String docAbstract;

    /**
     * 关键词
     */
    private List<String> keyWords;

    /**
     * PDF 链接
     */
    private String pdfLink;

    /**
     * 被引用次数
     */
    private Integer refs;

    /**
     * 发表时间（年份）
     */
    private String time;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAffiliations() {
        return affiliations;
    }

    public void setAffiliations(List<String> affiliations) {
        this.affiliations = affiliations;
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


    public String getPublicationTitle() {
        return publicationTitle;
    }

    public void setPublicationTitle(String publicationTitle) {
        this.publicationTitle = publicationTitle;
    }

    public String getDocAbstract() {
        return docAbstract;
    }

    public void setDocAbstract(String docAbstract) {
        this.docAbstract = docAbstract;
    }

    public List<String> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(List<String> keyWords) {
        this.keyWords = keyWords;
    }

    public String getPdfLink() {
        return pdfLink;
    }

    public void setPdfLink(String pdfLink) {
        this.pdfLink = pdfLink;
    }

    public Integer getRefs() {
        return refs;
    }

    public void setRefs(Integer refs) {
        this.refs = refs;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArticleItemVO() {
    }

    public ArticleItemVO(Integer articleId, String title, List<String> affiliations, List<String> authorNames, List<Integer> authorIds, String publicationTitle, String docAbstract, List<String> keyWords, String pdfLink, Integer refs, String time) {
        this.articleId = articleId;
        this.title = title;
        this.affiliations = affiliations;
        this.setAuthors(authorNames, authorIds);
        this.publicationTitle = publicationTitle;
        this.docAbstract = docAbstract;
        this.keyWords = keyWords;
        this.pdfLink = pdfLink;
        this.refs = refs;
        this.time = time;
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
        return "ArticleItemVO{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", affiliations=" + affiliations +
                ", authors=" + authors +
                ", publicationTitle='" + publicationTitle + '\'' +
                ", docAbstract='" + docAbstract + '\'' +
                ", keyWords=" + keyWords +
                ", pdfLink='" + pdfLink + '\'' +
                ", refs=" + refs +
                ", time='" + time + '\'' +
                '}';
    }

}
