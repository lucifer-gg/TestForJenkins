package oasis.entity.chart;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/04/10 09:23
 * @description 作者结点 PO
 */
public class AuthorNodePO {

    /**
     * 作者姓名
     */
    private String name;

    /**
     * 作者活跃度
     */
    private int symbolSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSymbolSize() {
        return symbolSize;
    }

    public void setSymbolSize(int symbolSize) {
        this.symbolSize = symbolSize;
    }

    public AuthorNodePO() {
    }

    public AuthorNodePO(String name, int symbolSize) {
        this.name = name;
        this.symbolSize = symbolSize;
    }

}
