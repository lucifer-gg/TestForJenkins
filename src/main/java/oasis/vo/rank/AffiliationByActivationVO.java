package oasis.vo.rank;

public class AffiliationByActivationVO {
    /**
     * @author cmw
     * @version 1.0
     * @date 2020/03/29 16.50
     * @description 包含活跃度的机构 VO 类
     */

    private String affiliationName;
    private int affiliationId;
    private int activation;

    public AffiliationByActivationVO(String affiliationName, int affiliationId, int activation) {
        this.affiliationName = affiliationName;
        this.affiliationId = affiliationId;
        this.activation = activation;
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

    public int getActivation() {
        return activation;
    }

    public void setActivation(int activation) {
        this.activation = activation;
    }
}
