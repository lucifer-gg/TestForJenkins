package oasis.entity.chart;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/04/02 09:20
 * @description 每年的 H-Index PO
 */
public class AnnualHindexPO {

    /**
     * 年份
     */
    private String year;

    /**
     * H-Index
     */
    private int hindex;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getHindex() {
        return hindex;
    }

    public void setHindex(int hindex) {
        this.hindex = hindex;
    }

    public AnnualHindexPO() {
    }

    public AnnualHindexPO(String year, int hindex) {
        this.year = year;
        this.hindex = hindex;
    }

}
