package oasis.vo.entity;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/29 19:16
 * @description 检索所得的会议 VO 类
 */
public class PublicationSearchedVO {

    /**
     * 会议编号
     */
    private Integer publicationId;

    /**
     * 会议名称
     */
    private String publicationTitle;

    /**
     * 论文数量
     */
    private Integer articleNum;

    /**
     * 总引用数
     */
    private Integer reference;

    /**
     * H-Index
     */
    private Integer hindex;

    public Integer getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(Integer publicationId) {
        this.publicationId = publicationId;
    }

    public String getPublicationTitle() {
        return publicationTitle;
    }

    public void setPublicationTitle(String publicationTitle) {
        this.publicationTitle = publicationTitle;
    }

    public Integer getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Integer articleNum) {
        this.articleNum = articleNum;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public Integer getHindex() {
        return hindex;
    }

    public void setHindex(Integer hindex) {
        this.hindex = hindex;
    }

    public PublicationSearchedVO() {
    }

    public PublicationSearchedVO(Integer publicationId, String publicationTitle, Integer articleNum, Integer reference, Integer hindex) {
        this.publicationId = publicationId;
        this.publicationTitle = publicationTitle;
        this.articleNum = articleNum;
        this.reference = reference;
        this.hindex = hindex;
    }

}
