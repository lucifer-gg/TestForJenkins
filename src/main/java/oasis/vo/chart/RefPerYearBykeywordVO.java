package oasis.vo.chart;

import java.util.List;

/**
 * @author cmw
 * @version 2.0
 * @date 2020/4.2
 * @description 查看某研究方向每年的引用数量VO
 */
public class RefPerYearBykeywordVO {
    private List<String> yearList;
    private List<Integer> refList;

    public RefPerYearBykeywordVO(List<String> yearList, List<Integer> refList) {
        this.yearList = yearList;
        this.refList = refList;
    }

    public List<String> getYearList() {
        return yearList;
    }

    public void setYearList(List<String> yearList) {
        this.yearList = yearList;
    }

    public List<Integer> getRefList() {
        return refList;
    }

    public void setRefList(List<Integer> refList) {
        this.refList = refList;
    }
}
