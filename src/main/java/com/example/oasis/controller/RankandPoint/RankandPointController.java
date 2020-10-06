package com.example.oasis.controller.RankandPoint;
import com.example.oasis.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.oasis.blImpl.RankandPoint.RankandPointServiceImpl;

@RestController
@RequestMapping("/domain")
public class RankandPointController {
    @Autowired
    private RankandPointServiceImpl rankandPointService;

    //获得作者领域排名
    @RequestMapping(value ="/{domain}",method = RequestMethod.GET)
    public ResponseVO domainRank(@PathVariable String domain){return rankandPointService.AuthorRank(domain);};

    //获得作者领域排名前三，为关键学者
    @RequestMapping(value ="/{domain}/keyAuthor",method = RequestMethod.GET)
    public ResponseVO domainRankThree(@PathVariable String domain){return rankandPointService.AuthorRankThree(domain);};


}
