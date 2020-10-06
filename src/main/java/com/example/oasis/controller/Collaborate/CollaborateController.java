package com.example.oasis.controller.Collaborate;
import com.example.oasis.vo.*;
import com.example.oasis.bl.Collaborate.CollaborateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/collaborate")
public class CollaborateController {
    @Autowired
    private CollaborateService collaborateService;

    //根据作者的id来获得作者的合作关系
    @RequestMapping(value ="/author/{authorId}",method = RequestMethod.GET)
    public ResponseVO getByAuthor(@PathVariable int authorId){
        return collaborateService.getCollaborateByAuthor(authorId);
    }

    //根据机构的名字来获得机构之间的合作关系
    @RequestMapping(value ="/organ/{organ}",method = RequestMethod.GET)
    public ResponseVO userGet(@PathVariable String organ){
        return collaborateService.getCollaborateByOrgan(organ);
    }
}
