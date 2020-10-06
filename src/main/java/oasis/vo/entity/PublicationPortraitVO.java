package oasis.vo.entity;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/30 16:42
 * @description 会议画像 VO 类
 */
public class PublicationPortraitVO {

    /**
     * 会议名称
     */
    private String publicationTitle;

    /**
     * 论文数量
     */
    private Integer articleNum;

    /**
     * 论文总引用数
     */
    private Integer reference;

    /**
     * H-Index
     */
    private Integer hindex;

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

    public PublicationPortraitVO() {
    }

    public PublicationPortraitVO(String publicationTitle, Integer articleNum, Integer reference, Integer hindex) {
        this.publicationTitle = publicationTitle;
        this.articleNum = articleNum;
        this.reference = reference;
        this.hindex = hindex;
    }

}
