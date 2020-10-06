package oasis.entity.rank;

/**
 * @author cmw
 * @version 2.1
 * @date 2020/03/29 17:27
 * @description 根据活跃度排名的机构PO
 *
 */
public class RankAffiliationByActivationPO {
    private String affiliationName;
    private int affiliationId;
    private int affiliationActivation;

    public RankAffiliationByActivationPO(String affiliationName, int affiliationId, int affiliationActivation) {
        this.affiliationName = affiliationName;
        this.affiliationId = affiliationId;
        this.affiliationActivation = affiliationActivation;
    }

    public String getAffiliationName() {
        return affiliationName;
    }

    public void setAffiliationName(String affiliationName) {
        this.affiliationName = affiliationName;
    }

    public int getAffiliationId() {
        return affiliationId;
    }

    public void setAffiliationId(int affiliationId) {
        this.affiliationId = affiliationId;
    }

    public int getAffiliationActivation() {
        return affiliationActivation;
    }

    public void setAffiliationActivation(int affiliationActivation) {
        this.affiliationActivation = affiliationActivation;
    }
}
