package oasis.controller.chart;

import oasis.bl.chart.ChartService;
import oasis.vo.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author cmw
 * @version 2.2
 * @date 2020/03/30 21:43
 * @description 图表控制器
 */

@CrossOrigin
@RestController
@RequestMapping("/chart")
public class ChartController {

    @Autowired
    private ChartService chartService;

    public ChartController(ChartService chartService) {
        this.chartService=chartService;
    }

    @GetMapping("/articlePerYearByKeyword")
    public BasicResponse getArticlePerYearByKeyword(@RequestParam int keywordId) {
        return chartService.getArticlePerYearByKeyword(keywordId);
    }

    @GetMapping("/referencePerYearByPublication")
    public BasicResponse getReferencePerYearByPublication(@RequestParam String publicationTitle) {
        return chartService.getReferencePerYearByPublication(publicationTitle);
    }

    @GetMapping("/hindexPerYearByPublication")
    public BasicResponse getHindexPerYearByPublication(@RequestParam String publicationTitle) {
        return chartService.getHindexPerYearByPublication(publicationTitle);
    }

    @GetMapping("/articlePerYearByPublication")
    public BasicResponse getArticlePerYearByPublication(@RequestParam String publicationTitle) {
        return chartService.getArticlePerYearByPublication(publicationTitle);
    }

    @GetMapping("/topKeywordByPublication")
    public BasicResponse getTopKeywordByPublication(@RequestParam String publicationTitle) {
        return chartService.getTopKeywordByPublication(publicationTitle);
    }

    @GetMapping("/articlePerYearByAuthor")
    public BasicResponse getAuthorAnnualArticle(@RequestParam int authorId) {
        return chartService.getAuthorAnnualArticle(authorId);
    }

    @GetMapping("/articlePerYearByAffiliation")
    public BasicResponse getAffiliationAnnualArticle(@RequestParam int affiliationId) {
        return chartService.getAffiliationAnnualArticle(affiliationId);
    }

    @GetMapping("/keywordDistribution")
    public BasicResponse getKeywordDistribution(@RequestParam int affiliationId) {
        return chartService.getKeywordDistribution(affiliationId);
    }

    @GetMapping("/hindexPerYearByAffiliation")
    public BasicResponse getAffiliationAnnualHindex(@RequestParam int affiliationId) {
        return chartService.getAffiliationAnnualHindex(affiliationId);
    }

    @GetMapping("/refPerYearBykeyword")
    public BasicResponse getRefPerYearBykeyword(@RequestParam int keywordId){
        return chartService.getRefPerYearBykeyword(keywordId);
    }

    @GetMapping("/hindexPerYearByKeyword")
    public BasicResponse getHindexPerYearByKeyword(@RequestParam int keywordId){
        return chartService.getHindexPerYearByKeyword(keywordId);
    }

    @GetMapping("/referencePerYearByAuthor")
    public BasicResponse getReferencePerYearByAuthor(@RequestParam int authorId){
        return chartService.getReferencePerYearByAuthor(authorId);
    }

    @GetMapping("/linkedDataByAuthor")
    public BasicResponse getLinkedDataByAuthor(@RequestParam int authorId){
        return chartService.getLinkedDataByAuthor(authorId);
    }

    @GetMapping("/totalAuthorLinkedData")
    public BasicResponse getTotalAuthorLinkedData(){
        return chartService.getTotalAuthorLinkedData();
    }

}
