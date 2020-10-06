package com.example.oasis.controller.search;

import com.example.oasis.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.oasis.blImpl.search.SearchServiceImpl;
import com.example.oasis.vo.SearchForm;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchServiceImpl searchService;

    /**
     *@描述  根据搜索条件返回搜索结果
     *@参数  [searchForm]
     *@返回值  com.example.oasis.vo.ResponseVO
     */
    @RequestMapping(value = "/word", method = RequestMethod.GET)
    public ResponseVO search(SearchForm searchForm) {
        return searchService.search(searchForm);
    }

}
