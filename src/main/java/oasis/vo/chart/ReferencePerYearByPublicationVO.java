package oasis.vo.chart;

import java.util.List;

/**
 * @author cmw
 * @version 2.0
 * @date 2020/03/31 17.50
 * @description 查看某会议每年的文章总引用量
 */
public class ReferencePerYearByPublicationVO {
    private List<String> yearList;
    private List<Integer> referenceList;

    public ReferencePerYearByPublicationVO(List<String> yearList, List<Integer> referenceList) {
        this.yearList = yearList;
        this.referenceList = referenceList;
    }

    public List<String> getYearList() {
        return yearList;
    }

    public void setYearList(List<String> yearList) {
        this.yearList = yearList;
    }

    public List<Integer> getReferenceList() {
        return referenceList;
    }

    public void setReferenceList(List<Integer> referenceList) {
        this.referenceList = referenceList;
    }
}
