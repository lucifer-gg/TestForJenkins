package com.example.oasis.controller.Interface;

import com.example.oasis.blImpl.Interface.InterfaceServiceImpl;
import com.example.oasis.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/interface")
public class InterfaceController {
    @Autowired
    private InterfaceServiceImpl interfaceService;

    //获得作者界面的信息
    @RequestMapping(value ="/author/{authorId}",method = RequestMethod.GET)
    public ResponseVO userGet(@PathVariable int authorId){
        return interfaceService.authorInterface(authorId);
    }
    //获得作者的总热度
    @RequestMapping(value ="/totalHot/{authorId}",method = RequestMethod.GET)
    public ResponseVO totalHotGet(@PathVariable int authorId){
        return interfaceService.totalHotNumGet(authorId);
    }
    //获得文章的信息
    @RequestMapping(value ="/paper/{paperId}",method = RequestMethod.GET)
    public ResponseVO paperGet(@PathVariable int paperId){
        return interfaceService.paperInterface(paperId);
    }
    //获得文章的排名
    @RequestMapping(value ="/rank/paperRank",method = RequestMethod.GET)
    public ResponseVO getPaperRank(){return interfaceService.getPaperRank();};
    //获得作者的文章的信息
    @RequestMapping(value ="/authorPaper/{authorId}",method = RequestMethod.GET)
    public ResponseVO userPaperGet(@PathVariable int authorId){
        return  interfaceService.authorPaperGet(authorId);
    }
    //获得与一篇文章相似的文章
    @RequestMapping(value ="/LikePaper/{paperId}",method = RequestMethod.GET)
    public ResponseVO userLikePaperGet(@PathVariable int paperId){
        return  interfaceService.LikePaper(paperId);
    }

}
