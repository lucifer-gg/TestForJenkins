package com.example.oasis.bl.DataChange;

public interface DataChangeService {

    /**
     *@描述 更新作者领域数据
     *@参数  []
     *@返回值  void
     */
    public void authorDomainChange();
    /**
     *@描述 更新作者研究领域数据
     *@参数  []
     *@返回值  void
     *@创建人  Chen Hongyu
     */
    public void authorSpotChange();
    /**
     *@描述 更新论文邻域数据
     *@参数  []
     *@返回值  void
     *@创建人  Chen Hongyu
     */
    public void paperInfChange();
    /**
     *@描述 更新论文研究热点数据
     *@参数  []
     *@返回值  void
     *@创建人  Chen Hongyu
     */
    public void paperSpotChange();

}
