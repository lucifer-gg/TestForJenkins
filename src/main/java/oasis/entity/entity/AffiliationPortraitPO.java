package oasis.entity.entity;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/30 16:19
 * @description 机构画像 PO
 */
public class AffiliationPortraitPO {

    /**
     * 机构名称
     */
    private String affiliationName;

    /**
     * 活跃度
     */
    private int activation;

    /**
     * H-Index
     */
    private int hindex;

    public String getAffiliationName() {
        return affiliationName;
    }

    public void setAffiliationName(String affiliationName) {
        this.affiliationName = affiliationName;
    }

    public int getActivation() {
        return activation;
    }

    public void setActivation(int activation) {
        this.activation = activation;
    }

    public int getHindex() {
        return hindex;
    }

    public void setHindex(int hindex) {
        this.hindex = hindex;
    }

    public AffiliationPortraitPO() {
    }

    public AffiliationPortraitPO(String affiliationName, int activation, int hindex) {
        this.affiliationName = affiliationName;
        this.activation = activation;
        this.hindex = hindex;
    }

}
