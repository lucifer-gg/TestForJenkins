package oasis.vo.chart;

import java.util.List;

/**
 * @author cmw
 * @version 2.0
 * @date 2020/4/2
 * @description 查看某研究方向每年的H-IndexVO
 */
public class HindexPerYearByKeywordVO {
    private List<String > yearList;
    private List<Integer> hindexList;

    public HindexPerYearByKeywordVO(List<String> yearList, List<Integer> hindexList) {
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
