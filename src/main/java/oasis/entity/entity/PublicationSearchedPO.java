package oasis.entity.entity;

/**
 * @author L.T
 * @version 1.6
 * @date 2020/03/29 21:38
 * @description 检索所得作者会议 PO
 */
public class PublicationSearchedPO {

    /**
     * 会议编号
     */
    private Integer publicationId;

    /**
     * 会议名称
     */
    private String publicationTitle;

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

    public Integer getHindex() {
        return hindex;
    }

    public void setHindex(Integer hindex) {
        this.hindex = hindex;
    }

    public PublicationSearchedPO() {
    }

    public PublicationSearchedPO(Integer publicationId, String publicationTitle, Integer hindex) {
        this.publicationId = publicationId;
        this.publicationTitle = publicationTitle;
        this.hindex = hindex;
    }

}
