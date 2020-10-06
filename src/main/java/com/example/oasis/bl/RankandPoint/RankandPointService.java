package com.example.oasis.bl.RankandPoint;

import com.example.oasis.vo.ResponseVO;

public interface RankandPointService {
    //获得某个领域的排名
    public ResponseVO AuthorRank(String spot);
    //获得某个领域的关键学着，排名前三
    public ResponseVO AuthorRankThree(String spot);
}
