package oasis.entity.entity;

/**
 * @author L.T
 * @version 1.6
 * @date 2020/03/29 21:01
 * @description 检索所得机构信息 PO
 */
public class AffiliationSearchedPO {

    /**
     * 机构编号
     */
    private int affiliationId;

    /**
     * 机构名称
     */
    private String affiliationName;

    public int getAffiliationId() {
        return affiliationId;
    }

    public void setAffiliationId(int affiliationId) {
        this.affiliationId = affiliationId;
    }

    public String getAffiliationName() {
        return affiliationName;
    }

    public void setAffiliationName(String affiliationName) {
        this.affiliationName = affiliationName;
    }

    public AffiliationSearchedPO() {
    }

    public AffiliationSearchedPO(int affiliationId, String affiliationName) {
        this.affiliationId = affiliationId;
        this.affiliationName = affiliationName;
    }

}
