package com.example.oasis.data.RankandPoint;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.oasis.vo.*;
import java.util.List;


@Mapper
public interface RankandPointServiceMapper {
    /**
     * 根据领域获得排名
     * @param spot
     * @return
     */
    List<AuthorHot> getRank(@Param("spot") String spot);
}
