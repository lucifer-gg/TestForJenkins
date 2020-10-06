package oasis.vo.rank;

public class AffiliationByKeywordVO {
    /**
     * @author cmw
     * @version 2.0
     * @date 2020/03/30 19.48
     * @description 描述研究方向相关的机构VO 类
     */
    private String affiliationName;
    private int affiliationId;

    public AffiliationByKeywordVO(String affiliationName, int affiliationId) {
        this.affiliationName = affiliationName;
        this.affiliationId = affiliationId;
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
}
