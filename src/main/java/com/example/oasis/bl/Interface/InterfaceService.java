package com.example.oasis.bl.Interface;
import com.example.oasis.vo.ResponseVO;

import java.util.List;

public interface InterfaceService {
    //获得作者界面的信息
    public ResponseVO authorInterface(int authorid);
    //获得文章的信息
    public ResponseVO paperInterface(int paperid);
    //获得作者的文章的信息
    public ResponseVO authorPaperGet(int authorid);
    //获得作者的总热度
    public ResponseVO totalHotNumGet(int authorid);
    //获得与一篇文章相似的文章
    public ResponseVO LikePaper(int paperId);
    //获得文章的排名
    public ResponseVO getPaperRank();

}
