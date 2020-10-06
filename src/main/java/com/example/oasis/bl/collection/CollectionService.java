package com.example.oasis.bl.collection;
import com.example.oasis.vo.ResponseVO;
public interface CollectionService {
    //获得用户所有的收藏
    public  ResponseVO getCollection(int userId);
    //判断用户是否喜欢这个文章
    public  ResponseVO findCollection(int userId,int paperId);
    //取消对文章的喜欢
    public  ResponseVO deleteCollection(int userId,int paperId);
    //添加对文章的喜欢
    public  ResponseVO addCollection(int userId,int paperId);
}
