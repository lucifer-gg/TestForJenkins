package oasis.controller.rank;

import oasis.bl.rank.RankService;
import oasis.vo.BasicResponse;
import oasis.vo.ResponseStatus;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RankControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;
    private MockHttpSession session;

    @Test
    public void getTopAuthor() {
        RankService rankService=mock(RankService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(rankService.getTopAuthors()).thenReturn(br);
        RankController rankController=new RankController(rankService);
        MockMvc mockMvc = standaloneSetup(rankController).build();
        try {
            mockMvc.perform(get("/rank/topAuthor"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getTopReference() {
        RankService rankService=mock(RankService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(rankService.getTopReferences()).thenReturn(br);
        RankController rankController=new RankController(rankService);
        MockMvc mockMvc = standaloneSetup(rankController).build();
        try {
            mockMvc.perform(get("/rank/topReference"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTopKeyWords() {
        RankService rankService=mock(RankService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(rankService.getTopKeyWords()).thenReturn(br);
        RankController rankController=new RankController(rankService);
        MockMvc mockMvc = standaloneSetup(rankController).build();
        try {
            mockMvc.perform(get("/rank/topKeyWords"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAseTopAff() {
        RankService rankService=mock(RankService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(rankService.getAseTopAffiliations()).thenReturn(br);
        RankController rankController=new RankController(rankService);
        MockMvc mockMvc = standaloneSetup(rankController).build();
        try {
            mockMvc.perform(get("/rank/aseTopAff"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getIcseTopAff() {
        RankService rankService=mock(RankService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(rankService.getIcseTopAffiliations()).thenReturn(br);
        RankController rankController=new RankController(rankService);
        MockMvc mockMvc = standaloneSetup(rankController).build();
        try {
            mockMvc.perform(get("/rank/icseTopAff"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}