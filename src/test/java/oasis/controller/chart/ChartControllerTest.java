package oasis.controller.chart;

import oasis.bl.chart.ChartService;
import oasis.bl.rank.RankService;
import oasis.controller.rank.RankController;
import oasis.vo.BasicResponse;
import oasis.vo.ResponseStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ChartControllerTest {


    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;
    private MockHttpSession session;

    @Test
    public void getArticlePerYearByKeyword() {
        ChartService chartService=mock(ChartService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(chartService.getArticlePerYearByKeyword(1)).thenReturn(br);
        ChartController chartController=new ChartController(chartService);
        MockMvc mockMvc = standaloneSetup(chartController).build();
        try {
            mockMvc.perform(get("/chart/articlePerYearByKeyword?keywordId=1"));
        } catch (Exception e) {
            e.printStackTrace();
        }


}

    @Test
    public void getReferencePerYearByPublication() {
        ChartService chartService=mock(ChartService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(chartService.getReferencePerYearByPublication("ASE")).thenReturn(br);
        ChartController chartController=new ChartController(chartService);
        MockMvc mockMvc = standaloneSetup(chartController).build();
        try {
            mockMvc.perform(get("/chart/referencePerYearByPublication?PublicationTitle=ASE"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getHindexPerYearByPublication() {
        ChartService chartService=mock(ChartService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(chartService.getHindexPerYearByPublication("ASE")).thenReturn(br);
        ChartController chartController=new ChartController(chartService);
        MockMvc mockMvc = standaloneSetup(chartController).build();
        try {
            mockMvc.perform(get("/chart/hindexPerYearByPublication?publicationTitle=ASE"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getArticlePerYearByPublication() {
        ChartService chartService=mock(ChartService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(chartService.getArticlePerYearByPublication("ASE")).thenReturn(br);
        ChartController chartController=new ChartController(chartService);
        MockMvc mockMvc = standaloneSetup(chartController).build();
        try {
            mockMvc.perform(get("/chart/articlePerYearByPublication?publicationTitle=ASE"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTopKeywordByPublication() {
        ChartService chartService=mock(ChartService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(chartService.getTopKeywordByPublication("ASE")).thenReturn(br);
        ChartController chartController=new ChartController(chartService);
        MockMvc mockMvc = standaloneSetup(chartController).build();
        try {
            mockMvc.perform(get("/chart/topKeywordByPublication?publicationTitle=ASE"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAuthorAnnualArticle() {
        ChartService chartService=mock(ChartService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(chartService.getReferencePerYearByAuthor(1)).thenReturn(br);
        ChartController chartController=new ChartController(chartService);
        MockMvc mockMvc = standaloneSetup(chartController).build();
        try {
            mockMvc.perform(get("/chart/articlePerYearByAuthor?authorId=1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAffiliationAnnualArticle() {
        ChartService chartService=mock(ChartService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(chartService.getAffiliationAnnualArticle(1)).thenReturn(br);
        ChartController chartController=new ChartController(chartService);
        MockMvc mockMvc = standaloneSetup(chartController).build();
        try {
            mockMvc.perform(get("/chart/articlePerYearByAffiliation?affiliationId=1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getKeywordDistribution() {
        ChartService chartService=mock(ChartService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(chartService.getKeywordDistribution(1)).thenReturn(br);
        ChartController chartController=new ChartController(chartService);
        MockMvc mockMvc = standaloneSetup(chartController).build();
        try {
            mockMvc.perform(get("/chart/keywordDistribution?affiliationId=1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAffiliationAnnualHindex() {
        ChartService chartService=mock(ChartService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(chartService.getAffiliationAnnualHindex(1)).thenReturn(br);
        ChartController chartController=new ChartController(chartService);
        MockMvc mockMvc = standaloneSetup(chartController).build();
        try {
            mockMvc.perform(get("/chart/hindexPerYearByAffiliation?affiliationId=1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getRefPerYearBykeyword() {
        ChartService chartService=mock(ChartService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(chartService.getRefPerYearBykeyword(1)).thenReturn(br);
        ChartController chartController=new ChartController(chartService);
        MockMvc mockMvc = standaloneSetup(chartController).build();
        try {
            mockMvc.perform(get("/chart/refPerYearBykeyword?keywordId=1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getHindexPerYearByKeyword() {
        ChartService chartService=mock(ChartService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(chartService.getHindexPerYearByKeyword(1)).thenReturn(br);
        ChartController chartController=new ChartController(chartService);
        MockMvc mockMvc = standaloneSetup(chartController).build();
        try {
            mockMvc.perform(get("/chart/hindexPerYearByKeyword?keywordId=1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getReferencePerYearByAuthor() {
        ChartService chartService=mock(ChartService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(chartService.getReferencePerYearByAuthor(1)).thenReturn(br);
        ChartController chartController=new ChartController(chartService);
        MockMvc mockMvc = standaloneSetup(chartController).build();
        try {
            mockMvc.perform(get("/chart/referencePerYearByAuthor?authorId=1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}