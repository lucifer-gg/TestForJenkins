package com.example.oasis.bl.spot;

import com.example.oasis.vo.ResponseVO;

public interface SpotService {
    /**
     *@描述 获取研究热点数据
     *@参数  [spotname]
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    public ResponseVO getSpot(String spotname);
    /**
     *@描述 更新研究热点数据
     *@参数  []
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    public ResponseVO updateSpot();
    /**
     *@描述
     *@参数  [spotname]
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    public ResponseVO getOrganzation(String spotname);
    /**
     *@描述
     *@参数  [spotname]
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    public ResponseVO getAuthor(String spotname);
    /**
     *@描述 根据研究热点名称获取研究热点的时间变化趋势
     *@参数  [spotname]
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    public ResponseVO getSpotChange(String spotname);
    /**
     *@描述 根据研究热点对机构排名
     *@参数  []
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    public ResponseVO RankOrganzation();
    /**
     *@描述 对研究热点进行排名
     *@参数  []
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    public ResponseVO RankSpot();
    /**
     *@描述 获取机构下属作者
     *@参数  [name]
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    public ResponseVO getAuthorByOrag(String name);
    /**
     *@描述 获取机构的研究热点
     *@参数  [name]
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    public ResponseVO getSpotByOrag(String name);

}
