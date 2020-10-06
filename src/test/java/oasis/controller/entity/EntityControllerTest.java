package oasis.controller.entity;

import oasis.bl.entity.EntityService;
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
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityControllerTest {


    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;
    private MockHttpSession session;
    @Test
    public void searchAuthor() {
        EntityService entityService=mock(EntityService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(entityService.searchAuthor("ChenZhenYu")).thenReturn(br);
        EntityController entityController=new EntityController(entityService);
        MockMvc mockMvc = standaloneSetup(entityController).build();
        try {
            mockMvc.perform(get("/entity/searchAuthor?authorName=ChenZhenYu"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void searchAffiliation() {
        EntityService entityService=mock(EntityService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(entityService.searchAffiliation("test")).thenReturn(br);
        EntityController entityController=new EntityController(entityService);
        MockMvc mockMvc = standaloneSetup(entityController).build();
        try {
            mockMvc.perform(get("/entity/searchAffiliation?affiliationName=test"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchPublication() {
        EntityService entityService=mock(EntityService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(entityService.searchPublication("ASE")).thenReturn(br);
        EntityController entityController=new EntityController(entityService);
        MockMvc mockMvc = standaloneSetup(entityController).build();
        try {
            mockMvc.perform(get("/entity/searchPublication?publicationTitle=ASE"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchKeyword() {
        EntityService entityService=mock(EntityService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(entityService.searchKeyword("ai")).thenReturn(br);
        EntityController entityController=new EntityController(entityService);
        MockMvc mockMvc = standaloneSetup(entityController).build();
        try {
            mockMvc.perform(get("/entity/searchKeyword?keyword=ai"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void authorPortrait() {
        EntityService entityService=mock(EntityService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(entityService.authorPortrait(1)).thenReturn(br);
        EntityController entityController=new EntityController(entityService);
        MockMvc mockMvc = standaloneSetup(entityController).build();
        try {
            mockMvc.perform(get("/entity/authorPortrait?authodId=1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void affiliationPortrait() {
        EntityService entityService=mock(EntityService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(entityService.affiliationPortrait(1)).thenReturn(br);
        EntityController entityController=new EntityController(entityService);
        MockMvc mockMvc = standaloneSetup(entityController).build();
        try {
            mockMvc.perform(get("/entity/affiliationPortrait?affiliationId=1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void publicationPortrait() {
        EntityService entityService=mock(EntityService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(entityService.publicationPortrait("ASE")).thenReturn(br);
        EntityController entityController=new EntityController(entityService);
        MockMvc mockMvc = standaloneSetup(entityController).build();
        try {
            mockMvc.perform(get("/entity/publicationPortrait?publicationTitle=ASE"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void keywordPortrait() {
        EntityService entityService=mock(EntityService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(entityService.keywordPortrait(1)).thenReturn(br);
        EntityController entityController=new EntityController(entityService);
        MockMvc mockMvc = standaloneSetup(entityController).build();
        try {
            mockMvc.perform(get("/entity/keywordPortrait?keywordId=1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getSubAuthorsByAffiliation() {
        EntityService entityService=mock(EntityService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(entityService.getSubAuthorsByAffiliation(1)).thenReturn(br);
        EntityController entityController=new EntityController(entityService);
        MockMvc mockMvc = standaloneSetup(entityController).build();
        try {
            mockMvc.perform(get("/entity/getSubAuthorsByAffiliation?affiliationId=1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void relatedAuthors() {
        EntityService entityService=mock(EntityService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(entityService.getRelatedAuthors(1)).thenReturn(br);
        EntityController entityController=new EntityController(entityService);
        MockMvc mockMvc = standaloneSetup(entityController).build();
        try {
            mockMvc.perform(get("/entity/relatedAuthors?authorId=1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}