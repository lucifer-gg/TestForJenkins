package com.example.oasis.data.Collaborate;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.oasis.vo.*;
import java.util.List;


@Mapper
public interface CollaborateMapper {
    /**
     * 根据作者id获取合作关系
     * @param authorId
     * @return
     */
List<CollaborateChange> findCollaborationByAuthorId(@Param("authorId") int authorId);
    /**
     * 根据机构名字
     * @param organ
     * @return
     */
    List<CollaborateChange> findCollaborationByOrgan(@Param("organ") String organ);
}
