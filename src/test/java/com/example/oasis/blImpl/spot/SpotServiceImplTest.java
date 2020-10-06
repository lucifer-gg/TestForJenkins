package com.example.oasis.blImpl.spot;

import com.example.oasis.blImpl.show.ShowServiceImpl;
import com.example.oasis.po.OrganizationSpot;
import com.example.oasis.po.SpotChange;
import com.example.oasis.vo.AuthorSpotVO;
import com.example.oasis.vo.OrganizationSpotVO;
import com.example.oasis.vo.SpotChangeVO;
import com.example.oasis.vo.SpotVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpotServiceImplTest {
    @Autowired
    private SpotServiceImpl spotService;


    @Test
    public void getOrganzation() {
        List<OrganizationSpotVO> list=(List<OrganizationSpotVO>)spotService.getOrganzation("data analytics").getContent();
        for(OrganizationSpotVO spotVO:list){
            System.out.println(spotVO);
        }
//        OrganizationSpot organizationSpot1=new OrganizationSpot();
//        organizationSpot1.setOrganization(" MIT CSAIL, USA");
//        organizationSpot1.setSpotnum(2);
//        OrganizationSpot organizationSpot2=new OrganizationSpot();
//        organizationSpot2.setSpotnum(1);
//        organizationSpot2.setOrganization(" CEA, France");
//        OrganizationSpot organizationSpot3=new OrganizationSpot();
//        organizationSpot3.setSpotnum(1);
//        organizationSpot3.setOrganization(" Adobe, USA");
//        OrganizationSpot organizationSpot4=new OrganizationSpot();
//        organizationSpot4.setSpotnum(1);
//        organizationSpot4.setOrganization("MIT CSAIL, USA");
//        OrganizationSpotVO vo1=new OrganizationSpotVO(organizationSpot1);
//        OrganizationSpotVO vo2=new OrganizationSpotVO(organizationSpot2);
//        OrganizationSpotVO vo3=new OrganizationSpotVO(organizationSpot3);
//        OrganizationSpotVO vo4=new OrganizationSpotVO(organizationSpot4);
        assertEquals(5,list.size());

    }

    @Test
    public void getAuthor() {
        List<AuthorSpotVO> authorSpotVOS = (List<AuthorSpotVO>) spotService.getAuthor("data analytics").getContent();
        System.out.println("authorSpots: "+authorSpotVOS.size());
        assertEquals(5,authorSpotVOS.size());


    }

    @Test
    public void getSpotChange() {
        List<SpotChangeVO> spotChangeVOS=(List<SpotChangeVO>) spotService.getSpotChange("java").getContent();
        for(SpotChangeVO spotChangeVO:spotChangeVOS){
            System.out.println(spotChangeVO);
        }
        assertEquals(7,spotChangeVOS.size());
    }

    @Test
    public void rankOrganzation() {
        List<OrganizationSpotVO> organizationSpotVOS=(List<OrganizationSpotVO>) spotService.RankOrganzation().getContent();
        for(OrganizationSpotVO organizationSpotVO:organizationSpotVOS){
            System.out.println(organizationSpotVO);
        }
        assertEquals(10,organizationSpotVOS.size());
    }

    @Test
    public void rankSpot() {
        List<SpotVO> spotVOS=(List<SpotVO>)spotService.RankSpot().getContent();
        for(SpotVO spotVO:spotVOS){
            System.out.println(spotVO);
        }
        assertEquals(10,spotVOS.size());
    }

    @Test
    public void getAuthorByOrag() {
        List<AuthorSpotVO> authorSpotVOS=(List<AuthorSpotVO>)spotService.getAuthorByOrag("Nanjing University, China").getContent();
        assertEquals(3,authorSpotVOS.size());

    }

    @Test
    public void getSpotByOrag() {
        List<SpotVO> spotVOS=(List<SpotVO>)spotService.getSpotByOrag("Nanjing University, China").getContent();
        assertEquals(5,spotVOS.size());

    }
}