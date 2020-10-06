package oasis.controller.utils;

import oasis.bl.utils.UtilsService;
import oasis.vo.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author cmw
 * @version 2.0
 * @date 2020/03/29 18:29
 * @description 工具包控制器
 */
@CrossOrigin
@RestController
@RequestMapping("/utils")
public class UtilsController {

    @Autowired
    private UtilsService utilsService;

    public UtilsController(UtilsService utilService) {
        this.utilsService = utilService;
    }

    @GetMapping("/getKeyWordIdByTitle")
    public BasicResponse getKeyWordIdByTitle(@RequestParam String keyword) {
        return utilsService.getKeyWordIdByName(keyword);
    }

    @GetMapping("/getPublicationIdByTitle")
    public BasicResponse getPublicationIdByTitle(@RequestParam String publicationTitle) {
        return utilsService.getPublicationIdByName(publicationTitle);
    }

    @GetMapping("/getAffiliationIdByName")
    public BasicResponse getAffiliationIdByName(@RequestParam String affiliationName) {
        return utilsService.getAffiliationIdByName(affiliationName);
    }

}
