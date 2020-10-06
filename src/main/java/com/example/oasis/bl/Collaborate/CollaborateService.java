package com.example.oasis.bl.Collaborate;

import com.example.oasis.vo.ResponseVO;

public interface CollaborateService {
    //根据作者的id来获得作者的合作关系
    public ResponseVO getCollaborateByAuthor(int authorId);
    //根据机构的名字来获得机构之间的合作关系
    public ResponseVO getCollaborateByOrgan(String organ);
}
