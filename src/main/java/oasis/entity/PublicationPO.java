package oasis.entity;

/**
 * @author L.T
 * @version 1.6
 * @date 2020/03/01 19:30
 * @description 会议/期刊信息 PO
 */
public class PublicationPO {

    /**
     * 会议/期刊信息编号
     */
    private int publicationId;

    /**
     * 会议/期刊信息名称
     */
    private String publicationTitle;

    /**
     * 会议/期刊年份
     */
    private String publicationYear;

    public int getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(int publicationId) {
        this.publicationId = publicationId;
    }

    public String getPublicationTitle() {
        return publicationTitle;
    }

    public void setPublicationTitle(String publicationTitle) {
        this.publicationTitle = publicationTitle;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public PublicationPO() {
    }

    public PublicationPO(int publicationId, String publicationTitle, String publicationYear) {
        this.publicationId = publicationId;
        this.publicationTitle = publicationTitle;
        this.publicationYear = publicationYear;
    }

}
