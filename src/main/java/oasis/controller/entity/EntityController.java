package oasis.controller.entity;

import oasis.bl.entity.EntityService;
import oasis.vo.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/29 18:04
 * @description 排序控制器
 */
@CrossOrigin
@RestController
@RequestMapping("/entity")
public class EntityController {

    @Autowired
    private EntityService entityService;

    public EntityController(EntityService entityService) {
        this.entityService=entityService;
    }

    @GetMapping("/searchAuthor")
    public BasicResponse searchAuthor(@RequestParam String authorName) {
        return entityService.searchAuthor(authorName);
    }

    @GetMapping("/searchAffiliation")
    public BasicResponse searchAffiliation(@RequestParam String affiliationName) {
        return entityService.searchAffiliation(affiliationName);
    }

    @GetMapping("/searchPublication")
    public BasicResponse searchPublication(@RequestParam String publicationTitle) {
        return entityService.searchPublication(publicationTitle);
    }

    @GetMapping("/searchKeyword")
    public BasicResponse searchKeyword(@RequestParam String keyword) {
        return entityService.searchKeyword(keyword);
    }

    @GetMapping("/authorPortrait")
    public BasicResponse authorPortrait(@RequestParam int authorId) {
        return entityService.authorPortrait(authorId);
    }

    @GetMapping("/affiliationPortrait")
    public BasicResponse affiliationPortrait(@RequestParam int affiliationId) {
        return entityService.affiliationPortrait(affiliationId);
    }

    @GetMapping("/publicationPortrait")
    public BasicResponse publicationPortrait(@RequestParam String publicationTitle) {
        return entityService.publicationPortrait(publicationTitle);
    }

    @GetMapping("/keywordPortrait")
    public BasicResponse keywordPortrait(@RequestParam int keywordId) {
        return entityService.keywordPortrait(keywordId);
    }

//    @GetMapping("/relatedAuthors")
//    public BasicResponse getRelatedAuthors(@RequestParam int authorId) {
//        return entityService.getRelatedAuthors(authorId);
//    }

    @GetMapping("/getSubAuthorsByAffiliation")
    public BasicResponse getSubAuthorsByAffiliation(@RequestParam int affiliationId) {
        return entityService.getSubAuthorsByAffiliation(affiliationId);
    }

    @GetMapping("/relatedAuthors")
    public BasicResponse relatedAuthors(@RequestParam int authorId) {
        return entityService.recommendAuthors(authorId);
    }

    @GetMapping("/articleListByAuthor")
    public BasicResponse getArticlesByAuthor(@RequestParam int authorId) {
        return entityService.getArticlesByAuthor(authorId);
    }

    @GetMapping("/articleListByKeyword")
    public BasicResponse getArticlesByKeyword(@RequestParam int keywordId) {
        return entityService.getArticlesByKeyword(keywordId);
    }

    @GetMapping("/getEntitiesNum")
    public BasicResponse getEntitiesNum() {
        return entityService.getEntitiesNum();
    }

}