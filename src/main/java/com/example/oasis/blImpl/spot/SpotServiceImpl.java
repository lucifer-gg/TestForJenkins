package com.example.oasis.blImpl.spot;

import com.example.oasis.bl.spot.SpotService;
import com.example.oasis.data.show.ShowServiceMapper;
import com.example.oasis.data.spot.SpotServiceMapper;
import com.example.oasis.po.*;
import com.example.oasis.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpotServiceImpl implements SpotService {

    @Autowired
    private SpotServiceMapper spotServiceMapper;

    @Autowired
    private ShowServiceMapper showServiceMapper;

    private ArrayList<SpotItem> spotItemArrayList;

    @Override
    public ResponseVO getSpot(String spotname){
        spotServiceMapper.selectSpotByName(spotname);
        return ResponseVO.buildSuccess();
    }
    /**
     *@描述 最终整合到在上传csv文件到ftp服务器后，更新研究热点相关数据
     *@参数  []
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    @Override
    public ResponseVO updateSpot(){
//        通过本地文件更新研究热点数据
//       String filepath="static\\uploadFile\\icse15_16_17_18_19.csv";
//        String filepath="static\\uploadFile\\demo.csv";
        //String filepath="static\\uploadFile\\ase13_15_16_17_19.csv";
//        String filepath="static\\uploadFile\\software.csv";
//        SpotTool spotTool=new SpotTool();
//        spotTool.parser(filepath);
//        spotItemArrayList=spotTool.getSpotItemArrayList();
//        for(SpotItem spotItem:spotItemArrayList){
//            spotServiceMapper.updateSpotItem(spotItem);
//        }
//        List<Spot> spotList = new ArrayList<>();
//        spotList=spotServiceMapper.getSpot();
//        for(Spot spot:spotList){
//            System.out.println(spot);
//            spotServiceMapper.updateSpot(new SpotVO(spot));
//
//        }
//        System.out.println("finish!");
        return ResponseVO.buildSuccess("更新成功！");
    }

    @Override
    public ResponseVO getOrganzation(String spotname){
        return ResponseVO.buildSuccess(OraganizationTransfer(
                spotServiceMapper.selectOrganizationSpot(spotname)
        ));
    }

    @Override
    public ResponseVO getAuthor(String spotname){
        return ResponseVO.buildSuccess(AuthorTransfer(
                spotServiceMapper.selectAuthorSpot(spotname)
        ));
    }

    @Override
    public ResponseVO getSpotChange(String spotname){
        return ResponseVO.buildSuccess(SpotTransfer(
                spotServiceMapper.selectSpotChange(spotname)
        ));
    }

    @Override
    public ResponseVO RankOrganzation(){
        return ResponseVO.buildSuccess(OraganizationTransfer(
           spotServiceMapper.RankOrganization()
        ));
    }

    @Override
    public ResponseVO RankSpot(){
        return ResponseVO.buildSuccess(RankSpotTransfer(
           spotServiceMapper.RankSpot()
        ));
    }

    @Override
    public ResponseVO getAuthorByOrag(String name){
        return ResponseVO.buildSuccess(AuthorTransfer(
                spotServiceMapper.getAuthorByOrag(name)
        ));
    }

    @Override
    public ResponseVO getSpotByOrag(String name){
        return ResponseVO.buildSuccess(RankSpotTransfer(
                spotServiceMapper.getSpotByOrag(name)
        ));
    }



    private List<OrganizationSpotVO> OraganizationTransfer(List<OrganizationSpot> organizationSpots){
        List<OrganizationSpotVO> organizationSpotVOList=new ArrayList<>();
        for(OrganizationSpot spot:organizationSpots){
            organizationSpotVOList.add(new OrganizationSpotVO(spot));
        }
        return organizationSpotVOList;
    }

    private List<AuthorSpotVO> AuthorTransfer(List<AuthorSpot> authorSpots){
        List<AuthorSpotVO> authorSpotVOS=new ArrayList<>();
        for(AuthorSpot spot:authorSpots){
            Author author=showServiceMapper.selectAuthorByName(spot.getAuthor());
            AuthorSpotVO authorSpotVO=new AuthorSpotVO(spot);
            if(author!=null) {
                authorSpotVO.setAuthorid(author.getAuthor_id());
            }
            else {
//                如果论文没有作者，则将作者id设为默认值0
                authorSpotVO.setAuthorid(0);
            }
            authorSpotVOS.add(authorSpotVO);
        }
        return authorSpotVOS;
    }

    private List<SpotChangeVO> SpotTransfer(List<SpotChange> spotChanges){
        List<SpotChangeVO> spotChangeVOS=new ArrayList<>();
        for(SpotChange spotChange:spotChanges){
            spotChangeVOS.add(new SpotChangeVO(spotChange));
        }
        return spotChangeVOS;
    }


    private List<SpotVO> RankSpotTransfer(List<Spot> spots){
        List<SpotVO> spotVOS=new ArrayList<>();
        for(Spot spot:spots){
            spotVOS.add(new SpotVO(spot));
        }
        return spotVOS;
    }



}
