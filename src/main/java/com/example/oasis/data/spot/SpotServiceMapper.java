package com.example.oasis.data.spot;

import com.example.oasis.po.*;
import com.example.oasis.vo.SpotVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpotServiceMapper {
/*
根据研究热点名称获取研究热点信息
 */
    public Spot selectSpotByName(@Param("spotname") String name);
/*
更新研究热点数据
 */
    public int updateSpot(SpotVO spotVO);
/*
更新研究热点数据
 */
    public int updateSpotItem(SpotItem spotItem);
    /*
    获取热点变化趋势
     */
    public List<SpotChange> selectSpotChange(@Param("spotname") String name);
    /*
    获取热点相关的作者
     */
    public List<AuthorSpot> selectAuthorSpot(@Param("spotname") String name);
    /*
    获取热点相关的机构
     */
    public List<OrganizationSpot> selectOrganizationSpot(@Param("spotname") String name);
    /*
    生成热点
     */
    public List<Spot> getSpot();
    /*
    获得机构排名
     */
    public List<OrganizationSpot> RankOrganization();
    /*
    获得热点排名
     */
    public List<Spot> RankSpot();
    /*
    获取机构作者
     */
    public List<AuthorSpot> getAuthorByOrag(@Param("orag") String name);

    /*
    获取机构热点
     */
    public List<Spot> getSpotByOrag(@Param("orag") String name);


}
