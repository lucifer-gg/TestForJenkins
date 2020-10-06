package oasis.entity.chart;


/**
 * @author cmw
 * @version 2.0
 * @date 2020/03/31 16.55
 * @description 会议每年的hindex PO
 */

public class HinderPerYearPO {

    private String publicationYear;

    private int hindex;

    public HinderPerYearPO(String publicationYear, int hindex) {
        this.publicationYear = publicationYear;
        this.hindex = hindex;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getHindex() {
        return hindex;
    }

    public void setHindex(int hindex) {
        this.hindex = hindex;
    }

}
