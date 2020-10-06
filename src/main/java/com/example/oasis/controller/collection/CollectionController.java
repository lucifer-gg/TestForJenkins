package com.example.oasis.controller.collection;
import com.example.oasis.vo.*;
import com.example.oasis.bl.collection.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/collection")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    //获得用户所有的收藏
    @RequestMapping(value ="/userAll/{userId}",method = RequestMethod.GET)
    public  ResponseVO getAllCollection(@PathVariable int userId){
        return  collectionService.getCollection(userId);
    }

    //判断用户是否喜欢这个文章
    @RequestMapping(value ="/user/like",method = RequestMethod.GET)
    public  ResponseVO getIfLike(int userId,int paperId){
        return collectionService.findCollection(userId,paperId);
    }

    //取消对文章的喜欢
    @RequestMapping(value ="/user/delete")
    private  ResponseVO deleteLike(int userId,int paperId){
        return  collectionService.deleteCollection(userId,paperId);

    }

    //添加对文章的喜欢
    @RequestMapping(value ="/user/add")
    public ResponseVO addLike(int userId,int paperId){
        return  collectionService.addCollection(userId,paperId);
    }

}
