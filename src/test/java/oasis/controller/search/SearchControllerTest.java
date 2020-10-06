package oasis.controller.search;

import oasis.bl.search.SearchService;
import oasis.vo.BasicResponse;
import oasis.vo.ResponseStatus;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
public class SearchControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;
    private MockHttpSession session;

    @Test
    public void searchItem() {
        SearchService searchService=mock(SearchService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(searchService.getArtItem(Mockito.any())).thenReturn(br);
        SearchController searchController=new SearchController(searchService);
        MockMvc mockMvc = standaloneSetup(searchController).build();
        try {
            mockMvc.perform(get("/search/item"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchDetail() {
        SearchService searchService=mock(SearchService.class);
        ResponseStatus responseStatus=ResponseStatus.STATUS_SUCCESS;
        BasicResponse br=new BasicResponse(responseStatus);
        when(searchService.getArtDetailById(1)).thenReturn(br);
        SearchController searchController=new SearchController(searchService);
        MockMvc mockMvc = standaloneSetup(searchController).build();
        try {
            mockMvc.perform(get("/search/detail").param("articleId","1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}