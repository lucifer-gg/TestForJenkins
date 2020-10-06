package oasis.entity.entity;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/30 14:10
 * @description 作者画像 PO
 */
public class AuthorPortraitPO {

    /**
     * 作者姓名
     */
    private String name;

    /**
     * 作者H-Index
     */
    private int hindex;

    /**
     * 作者活跃度
     */
    private int activation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHindex() {
        return hindex;
    }

    public void setHindex(int hindex) {
        this.hindex = hindex;
    }

    public int getActivation() {
        return activation;
    }

    public void setActivation(int activation) {
        this.activation = activation;
    }

    public AuthorPortraitPO() {
    }

    public AuthorPortraitPO(String name, int hindex, int activation) {
        this.name = name;
        this.hindex = hindex;
        this.activation = activation;
    }

}
