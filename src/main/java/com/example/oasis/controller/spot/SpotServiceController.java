package com.example.oasis.controller.spot;

import com.example.oasis.blImpl.spot.SpotServiceImpl;
import com.example.oasis.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/spot")
public class SpotServiceController {
    @Autowired
    private SpotServiceImpl spotService;

    /**
     *@描述 对关键词（研究热点）数据进行更新
     *@参数  []
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    @RequestMapping(value = "/update")
    public ResponseVO updateSpot() {
        return spotService.updateSpot();
    }


    /**
     *@描述  获取热点的研究变化趋势
     *@参数  [spotname]
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    @RequestMapping(value = "/getChange/{spotname}", method = RequestMethod.GET)
    public ResponseVO getSpotChange(@PathVariable String spotname) {
        return spotService.getSpotChange(spotname);
    }

    /**
     *@描述 根据机构名称返回机构的研究热点
     *@参数  [spotname]
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    @RequestMapping(value = "/getOrganization/{spotname}", method = RequestMethod.GET)
    public ResponseVO getOraganization(@PathVariable String spotname) {
        return spotService.getOrganzation(spotname);
    }

    /**
     *@描述 根据作者姓名返回作者的研究热点
     *@参数  [spotname]
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    @RequestMapping(value = "/getAuthor/{spotname}", method = RequestMethod.GET)
    public ResponseVO getAuthor(@PathVariable String spotname) {
        return spotService.getAuthor(spotname);
    }

    /**
     *@描述 获取机构排名，根据机构的研究热度
     *@参数  []
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    @RequestMapping(value = "/RankOrganization", method = RequestMethod.GET)
    public ResponseVO RankOrganization() {
        return spotService.RankOrganzation();
    }

    /**
     *@描述 返回研究热点的排名
     *@参数  []
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    @RequestMapping(value = "/RankSpot", method = RequestMethod.GET)
    public ResponseVO RankSpot() {
        return spotService.RankSpot();
    }


    /**
     *@描述 根据机构名称返回与机构有关的作者信息
     *@参数  [oragname]
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    @RequestMapping(value = "/authordetail/{oragname}", method = RequestMethod.GET)
    public ResponseVO getAuthorByOrag(@PathVariable String oragname) {
        return spotService.getAuthorByOrag(oragname.replace('|', ','));
    }

    /**
     *@描述  根据机构名称返回机构研究热点的相关信息
     *@参数  [oragname]
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    @RequestMapping(value = "/spotdetail/{oragname}", method = RequestMethod.GET)
    public ResponseVO getSpotByOrag(@PathVariable String oragname) {
        return spotService.getSpotByOrag(oragname.replace('|', ','));
    }

}
