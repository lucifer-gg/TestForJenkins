package com.example.oasis.controller.show;



import com.example.oasis.blImpl.show.ShowServiceImpl;
import com.example.oasis.data.show.ShowServiceMapper;
import com.example.oasis.po.Author;
import com.example.oasis.po.Paper;
import org.junit.jupiter.api.Test;

import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class ShowControllerTest {



    // @Test
    // void show() throws Exception{
    //     ShowServiceImpl showService=mock(ShowServiceImpl.class);
    //     ShowController showController = new ShowController(showService);
    //     MockMvc mockMvc = standaloneSetup(showController).build();
    //     mockMvc.perform(get("/show"))
    //             .andExpect(view().name("showDetil"));
    // }

    // @Test
    // void getPaper() throws Exception{
    //     ShowServiceImpl showService=mock(ShowServiceImpl.class);
    //     ShowController showController = new ShowController(showService);
    //     MockMvc mockMvc = standaloneSetup(showController).build();
    //     mockMvc.perform(post("/paper")
    //     .param("Document_Title","Toward Practical Automatic Program Repair"))
    //             .andExpect(view().name("Paper"));

    // }


    // @Test
    // void getAuthor() throws Exception{
    //     ShowServiceImpl showService=mock(ShowServiceImpl.class);
    //     ShowController showController = new ShowController(showService);
    //     MockMvc mockMvc = standaloneSetup(showController).build();
    //     mockMvc.perform(post("/author")
    //             .param("Author_name","A. Ghanbari"))
    //             .andExpect(view().name("Author"));



    // }

    // @Test
    // void rankAuthor() throws Exception{
    //     List<Author> authorList=new ArrayList<>();
    //     ShowServiceMapper showServiceMapper=mock(ShowServiceMapper.class);
    //     when(showServiceMapper.selectRankAuthor())
    //             .thenReturn(authorList);
    //     ShowServiceImpl showService=mock(ShowServiceImpl.class);
    //     ShowController showController = new ShowController(showService);
    //     MockMvc mockMvc = standaloneSetup(showController).build();
    //     mockMvc.perform(get("/rankauthor"))
    //             .andExpect(view().name("AuthorRank"))
    //             .andExpect(model().attributeExists("Authors"))
    //             .andExpect(model().attribute("Authors",
    //                     hasItems(authorList.toArray())));

    // }

    // @Test
    // void rankPaper() throws Exception{
    //     List<Paper> paperList=new ArrayList<>();
    //     ShowServiceMapper showServiceMapper=mock(ShowServiceMapper.class);
    //     when(showServiceMapper.selectRankPaper())
    //             .thenReturn(paperList);
    //     ShowServiceImpl showService=mock(ShowServiceImpl.class);
    //     ShowController showController = new ShowController(showService);
    //     MockMvc mockMvc = standaloneSetup(showController).build();
    //     mockMvc.perform(get("/rankpaper"))
    //             .andExpect(view().name("PaperRank"))
    //             .andExpect(model().attributeExists("Papers"))
    //             .andExpect(model().attribute("Papers",
    //                     hasItems(paperList.toArray())));
    // }





}