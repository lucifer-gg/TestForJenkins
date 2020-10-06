package com.example.oasis.blImpl.collection;

import com.example.oasis.vo.*;
import com.example.oasis.data.collection.CollectionMapper;
import  com.example.oasis.bl.collection.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionServiceImpl implements  CollectionService{
    @Autowired
    private CollectionMapper collectionMapper;

    //获得用户所有的收藏
    @Override
    public ResponseVO getCollection(int userId) {
        return  ResponseVO.buildSuccess(collectionMapper.get(userId));

    }

    //判断用户是否喜欢这个文章
    @Override
    public ResponseVO findCollection(int userId, int paperId) {
        int count=collectionMapper.find(userId,paperId);
        return ResponseVO.buildSuccess(count);
    }
    //取消对文章的喜欢
    @Override
    public ResponseVO deleteCollection(int userId, int paperId) {
        try {
            collectionMapper.delete(userId, paperId);
            return ResponseVO.buildSuccess("删除成功");
        } catch (Exception e) {
            return ResponseVO.buildFailure("删除失败");
        }
    }

    //添加对文章的喜欢
    @Override
    public ResponseVO addCollection(int userId, int paperId) {
            collection c=new collection();
        try {
            c=collectionMapper.getInf(paperId);
            c.setUserId(userId);
            collectionMapper.add(c);
            return  ResponseVO.buildSuccess("收藏完毕");
        } catch (Exception e) {
            return ResponseVO.buildFailure("删除失败");
        }


    }
}
