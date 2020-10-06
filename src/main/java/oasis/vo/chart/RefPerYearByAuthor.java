package oasis.vo.chart;


import java.util.List;

/**
 * @author cmw
 * @version 2.0
 * @date 2020/4/4 17.50
 * @description 查看作者每年文章引用量id
 */
public class RefPerYearByAuthor {
    private List<String> yearList;
    private List<Integer> referenceList;

    public RefPerYearByAuthor(List<String> yearList, List<Integer> referenceList) {
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
