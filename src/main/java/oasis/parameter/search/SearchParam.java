package oasis.parameter.search;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/04 07:59
 * @description 搜索条目时的请求参数
 */
public class SearchParam {

    /**
     * 作者姓名
     */
    private String author;

    /**
     * 机构名称
     */
    private String affiliation;

    /**
     * 会议/期刊名称
     */
    private String publication;

    /**
     * 关键词
     */
    private String keyWords;

    /**
     * 时间
     */
    private String time;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public SearchParam() {
    }

    public SearchParam(String author, String affiliation, String publication, String keyWords, String time) {
        this.author = author;
        this.affiliation = affiliation;
        this.publication = publication;
        this.keyWords = keyWords;
        this.time = time;
    }

}
