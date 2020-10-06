package oasis.entity;

/**
 * @author L.T
 * @version 1.6
 * @date 2020/03/01 19:20
 * @description 机构信息 PO
 */
public class AffiliationPO {

    /**
     * 机构 ID
     */
    private int authorAffiliationId;

    /**
     * 机构名称
     */
    private String authorAffiliationName;

    /**
     * 机构检索次数
     */
    private int affiliationSearchTime;

    public int getAuthorAffiliationId() {
        return authorAffiliationId;
    }

    public void setAuthorAffiliationId(int authorAffiliationId) {
        this.authorAffiliationId = authorAffiliationId;
    }

    public String getAuthorAffiliationName() {
        return authorAffiliationName;
    }

    public void setAuthorAffiliationName(String authorAffiliationName) {
        this.authorAffiliationName = authorAffiliationName;
    }

    public int getAffiliationSearchTime() {
        return affiliationSearchTime;
    }

    public void setAffiliationSearchTime(int affiliationSearchTime) {
        this.affiliationSearchTime = affiliationSearchTime;
    }

    public AffiliationPO() {
    }

    public AffiliationPO(int authorAffiliationId, String authorAffiliationName, int affiliationSearchTime) {
        this.authorAffiliationId = authorAffiliationId;
        this.authorAffiliationName = authorAffiliationName;
        this.affiliationSearchTime = affiliationSearchTime;
    }

}
