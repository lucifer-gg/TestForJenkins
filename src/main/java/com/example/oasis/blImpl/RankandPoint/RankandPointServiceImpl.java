package com.example.oasis.blImpl.RankandPoint;

import com.example.oasis.bl.RankandPoint.RankandPointService;
import com.example.oasis.vo.AuthorHot;
import com.example.oasis.vo.ResponseVO;
import com.example.oasis.data.RankandPoint.RankandPointServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RankandPointServiceImpl implements RankandPointService {
    @Autowired
    private RankandPointServiceMapper rankandPointServiceMapper;
    private static String REGEX_CHINESE = "[\u4e00-\u9fa5]";// 中文正则
    public  String testStr(String s) {

        // 去除中文
        Pattern pat = Pattern.compile(REGEX_CHINESE);
        Matcher mat = pat.matcher(s);
        return mat.replaceAll("");
    }
    public ResponseVO AuthorRank(String spot) {
        //获得作者的排名
        List<AuthorHot> ahs = rankandPointServiceMapper.getRank(spot);
        if (ahs.size() != 0) {
            for(int i=0;i<ahs.size();i++){
                //去除作者名字中的中文乱码
                ahs.get(i).setAuthor(testStr(ahs.get(i).getAuthor()));
            }
            return ResponseVO.buildSuccess(ahs);
        }
        return ResponseVO.buildSuccess();
    }

    public ResponseVO AuthorRankThree(String spot) {
        //与上面相似，获得的是前三名而已
        List<AuthorHot> ahs = rankandPointServiceMapper.getRank(spot);
        List<AuthorHot> ahs_three = new ArrayList<>();
        if (ahs.size() == 0) {
            return ResponseVO.buildSuccess();
        } else {
            int length = ahs.size();
            if (length >= 3)
                length = 3;
            for (int i = 0; i < length; i++) {
                ahs_three.add(ahs.get(i));
            }
            return ResponseVO.buildSuccess(ahs_three);
        }

    }
}
