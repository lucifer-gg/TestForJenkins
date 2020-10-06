package com.example.oasis.data.collection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.oasis.vo.*;
import java.util.List;
@Mapper
public interface CollectionMapper {
    /**
     * 根据用户获得所有收藏
     * @param userId
     * @return
     */
    List<collection> get(@Param("userId") int userId);
    /**
     * 增加收藏
     * @return
     */
    void add(collection c);
    /**
     * 删除收藏
     * @param userId
     * @param paperId
     * @return
     */
    void delete(@Param("userId") int userId,@Param("paperId") int paperId);
    /**
     * 找到收藏
     * @param userId
     * @param paperId
     * @return
     */
    int find(@Param("userId") int userId,@Param("paperId") int paperId);

    /**
     *
     */
    collection getInf(int paperId);
}
