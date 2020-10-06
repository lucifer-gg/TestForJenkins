package oasis.vo.rank;

import java.util.List;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/04/15 00:09
 * @description 热点趋势 VO 类
 */
public class HotTrendVO {

    /**
     * 关键字编号
     */
    private Integer keywordId;

    /**
     * 关键字名称
     */
    private String keyword;

    /**
     * 关键字Ratio【保留两位小数】
     */
    private String ratio;

    /**
     * 2015~2016年增长率
     */
    private String time1;

    /**
     * 2016~2017年增长率
     */
    private String time2;

    /**
     * 2017~2018年增长率
     */
    private String time3;

    /**
     * 2018~2019年增长率
     */
    private String time4;

    public Integer getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(Integer keywordId) {
        this.keywordId = keywordId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getTime3() {
        return time3;
    }

    public void setTime3(String time3) {
        this.time3 = time3;
    }

    public String getTime4() {
        return time4;
    }

    public void setTime4(String time4) {
        this.time4 = time4;
    }

    public HotTrendVO() {
    }

    public HotTrendVO(Integer keywordId, String keyword, String ratio, List<String> trendList) {
        this.keywordId = keywordId;
        this.keyword = keyword;
        this.ratio = ratio;
        this.time1 = trendList.get(0);
        this.time2 = trendList.get(1);
        this.time3 = trendList.get(2);
        this.time4 = trendList.get(3);
    }

    @Override
    public String toString() {
        return "HotTrendVO{" +
                "keywordId=" + keywordId +
                ", keyword='" + keyword + '\'' +
                ", ratio=" + ratio +
                ", time1='" + time1 + '\'' +
                ", time2='" + time2 + '\'' +
                ", time3='" + time3 + '\'' +
                ", time4='" + time4 + '\'' +
                '}';
    }

}
