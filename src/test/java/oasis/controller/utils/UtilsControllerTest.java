package oasis.controller.utils;

import oasis.bl.rank.RankService;
import oasis.bl.utils.UtilsService;
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
public class UtilsControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;
    private MockHttpSession session;

    @Test
    public void getKeyWordIdByTitle() {
        UtilsService utilService=mock(UtilsService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus,new Integer(1));
        when(utilService.getKeyWordIdByName("Google")).thenReturn(br);
        UtilsController utilsController=new UtilsController(utilService);
        MockMvc mockMvc = standaloneSetup(utilsController).build();
        try {
            mockMvc.perform(get("/utils/getKeyWordIdByTitle?keyword=Google"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getPublicationIdByTitle() {
        UtilsService utilService=mock(UtilsService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus,new Integer(1));
        when(utilService.getPublicationIdByName("test")).thenReturn(br);
        UtilsController utilsController=new UtilsController(utilService);
        MockMvc mockMvc = standaloneSetup(utilsController).build();
        try {
            mockMvc.perform(get("/utils/getPublicationIdByTitle?publicationTitle=test"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getAffiliationIdByName() {
        UtilsService utilService=mock(UtilsService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus,"1");
        when(utilService.getAffiliationIdByName("Google")).thenReturn(br);
        UtilsController utilsController=new UtilsController(utilService);
        MockMvc mockMvc = standaloneSetup(utilsController).build();
        try {
            mockMvc.perform(get("/utils/getAffiliationIdByName?affiliationName=Google"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}