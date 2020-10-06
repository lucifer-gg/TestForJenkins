package oasis.controller.search;

import oasis.bl.search.SearchService;
import oasis.parameter.search.SearchParam;
import oasis.vo.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/03 07:43
 * @description 搜索控制器
 */
@CrossOrigin
@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping(value = "/item")
    public BasicResponse searchItem(@RequestBody SearchParam searchParam) {
        return searchService.getArtItem(searchParam);
    }

    @GetMapping(value = "/detail")
    public BasicResponse searchDetail(@RequestParam int articleId) {
        return searchService.getArtDetailById(articleId);
    }

}
