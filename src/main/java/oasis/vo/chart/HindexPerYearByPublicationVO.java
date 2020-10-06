package oasis.vo.chart;

import java.util.List;

/**
 * @author cmw
 * @version 2.0
 * @date 2020/03/31 17.50
 * @description 查看某会议每年的H-Index
 */
public class HindexPerYearByPublicationVO {
    private List<String> yearList;
    private List<Integer> hindexList;

    public HindexPerYearByPublicationVO(List<String> yearList, List<Integer> hindexList) {
        this.yearList = yearList;
        this.hindexList = hindexList;
    }

    public List<String> getYearList() {
        return yearList;
    }

    public void setYearList(List<String> yearList) {
        this.yearList = yearList;
    }

    public List<Integer> getHindexList() {
        return hindexList;
    }

    public void setHindexList(List<Integer> hindexList) {
        this.hindexList = hindexList;
    }
}
