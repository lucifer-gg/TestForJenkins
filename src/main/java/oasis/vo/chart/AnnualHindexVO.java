package oasis.vo.chart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author L.T
 * @version 1.1
 * @date 2020/04/02 09:15
 * @description 每年的 H-Index VO 类
 */
public class AnnualHindexVO {

    /**
     * 年份列表
     */
    private List<String> yearList = new ArrayList<>();

    /**
     * H-Index 列表
     */
    private List<Integer> hindexList = new ArrayList<>();

    public List<String> getYearList() {
        return yearList;
    }

    public void setYearList(List<String> yearList) {
        this.yearList = yearList;
    }

    public void addYearList(String year) {
        this.yearList.add(year);
    }

    public List<Integer> getHindexList() {
        return hindexList;
    }

    public void setHindexList(List<Integer> hindexList) {
        this.hindexList = hindexList;
    }

    public void addHindexList(Integer hindex) {
        this.hindexList.add(hindex);
    }

    public void setHindex(String year, Integer hindex) {
        int index = this.yearList.indexOf(year);
        this.hindexList.set(index, hindex);
    }

    public AnnualHindexVO() {
    }

    public AnnualHindexVO(List<String> yearList, List<Integer> hindexList) {
        this.yearList = yearList;
        this.hindexList = hindexList;
    }

    @Override
    public String toString() {
        return "AnnualHindexVO{" +
                "yearList=" + yearList +
                ", hindexList=" + hindexList +
                '}';
    }

}
