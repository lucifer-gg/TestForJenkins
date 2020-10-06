package com.example.oasis.bl.search;
import com.example.oasis.vo.SearchForm;
import com.example.oasis.vo.ResponseVO;

public interface SearchService {
    /**
     *@描述 根据搜索表单返回符合条件的搜索结果
     *@参数  [searchForm]
     *@返回值  com.example.oasis.vo.ResponseVO
     *@创建人  Chen Hongyu
     */
    public ResponseVO search(SearchForm searchForm);
}
