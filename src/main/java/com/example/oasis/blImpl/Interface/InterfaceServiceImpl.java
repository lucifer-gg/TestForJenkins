package com.example.oasis.blImpl.Interface;

import com.example.oasis.vo.*;
import com.example.oasis.data.Interface.InterfaceServiceMapper;
import com.example.oasis.bl.Interface.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class InterfaceServiceImpl implements  InterfaceService {
    @Autowired
    private InterfaceServiceMapper interfaceServiceMapper;
    private static String REGEX_CHINESE = "[\u4e00-\u9fa5]";// 中文正则
    @Override
    public ResponseVO authorInterface(int authorid) {
        List<AuthorDomain> ad = interfaceServiceMapper.getAuthorDomain(authorid);
        UserInterfaceGet author = new UserInterfaceGet();
        int l1 = ad.size();
        if (l1 != 0) {
            //设置属性
            author.setAuthor(testStr(ad.get(0).getAuthor()));
            author.setIEEE(ad.get(0).getOrgan());
            for (int i = 0; i < l1; i++) {
                //设置领域和活跃度
                author.addDomain(ad.get(i).getDomain());
                author.adddomainHot(interfaceServiceMapper.getAuthorHot(ad.get(i).getDomain(), authorid));
            }
            return ResponseVO.buildSuccess(author);
        } else
            return ResponseVO.buildSuccess("没有此作者");

    }

    @Override
    public ResponseVO paperInterface(int paperId) {
        PaperInterfaceGet paper = new PaperInterfaceGet();
        //根据文章获得必要的信息
        List<PaperSpot> ps = interfaceServiceMapper.getPaperSpot(paperId);
        List<PaperInf> pis = interfaceServiceMapper.getInf(paperId);
        PaperInf pi = pis.get(0);
        List<Integer> authorids = new ArrayList<>();
        List<String> authors = new ArrayList<>();
        for (int i = 0; i < pis.size(); i++) {
            //设置作者
            authorids.add(pis.get(i).getAuthorId());
            authors.add(pis.get(i).getAuthor());
        }
        try {
            //设置各种属性
            authors=listStr(authors);
            paper.setAuthor(listStr(authors));
            paper.setDOI(pi.getDoi());
            paper.setAbstract(pi.getAbstracts());
            paper.setAuthorid(authorids);
            paper.setPaperid(pi.getPaperId());
            paper.setPaperHotNum(getPaperHot(pi.getPaperId()));
            paper.setTitle(pi.getTitle());
            paper.setTitleLink(pi.getPdfLink());
            paper.setTime(pi.getTime());
            paper.setPublishTitle(pi.getPublishTitle());
            paper.setRefNum(pi.getRedNum());
            //设置文章的领域，不超过五个
            int l1 = ps.size();
            if(l1>5)
                l1=5;
            for (int i = 0; i < l1; i++) {
                String spot=ps.get(i).getSpot().trim();
                if(!paper.getIEEE_terms().contains(spot)){
                paper.addterms(spot);
                    }
            }

            return ResponseVO.buildSuccess(paper);


        } catch (Exception e) {
            return ResponseVO.buildFailure("无此文章");
        }
    }

    public ResponseVO authorPaperGet(int authorid) {
        //获得作者的文章的有关信息
        List<PaperSpot> ap = interfaceServiceMapper.getAuthorPaper(authorid);
        int l2 = ap.size();
        if (l2 != 0) {
            List<String> ap_spots = new ArrayList<>();
            //添加文章的领域
            for (int i = 0; i < l2; i++) {
                if (!ap_spots.contains(ap.get(i).getSpot())) {
                    ap_spots.add(ap.get(i).getSpot());
                }
            }

            List<AuthorDomainPaper> adps = new ArrayList<>();
            int l3 = ap_spots.size();
            for (int i = 0; i < l3; i++) {
                AuthorDomainPaper adp = new AuthorDomainPaper();
                adp.setDomain(ap_spots.get(i));
                List<Integer> paper_ids=new ArrayList<>();
                for (int j = 0; j < l2; j++) {
                    if (ap_spots.get(i).equals(ap.get(j).getSpot())) {
                        //设置各种属性
                        AuthorPaper a = new AuthorPaper();
                        a.setAbstracts(ap.get(j).getAbstracts());
                        a.setAuthorId(ap.get(j).getAuthorId());
                        a.setPaperid(ap.get(j).getPaperId());
                        a.setPdfLink(ap.get(j).getPdfLink());
                        a.setTime(ap.get(j).getTime());
                        a.setTitle(ap.get(j).getTitle());
                        if (!paper_ids.contains(ap.get(j).getPaperId())) {
                            paper_ids.add(ap.get(j).getPaperId());
                            adp.add(a);
                        }
                    }

                }
                adps.add(adp);
            }
            return ResponseVO.buildSuccess(adps);
        } else
            return ResponseVO.buildSuccess();
    }

    public ResponseVO totalHotNumGet(int authorid) {
        //获得作者的领域和文章的信息
        List<AuthorDomain> ad = interfaceServiceMapper.getAuthorDomain(authorid);
        List<PaperSpot> ap = interfaceServiceMapper.getAuthorPaper(authorid);
        int l1 = ad.size();
        int l2 = ap.size();
        float total = 0;
        //计算作者总活跃度
        if (l1 != 0) {
            for (int i = 0; i < l1; i++) {
                total += interfaceServiceMapper.getAuthorHot(ad.get(i).getDomain(), authorid);
            }
        if (l2 != 0) {
            List<String> ap_spots = new ArrayList<>();
            for (int i = 0; i < l2; i++) {
                if (!ap_spots.contains(ap.get(i).getSpot())) {
                    ap_spots.add(ap.get(i).getSpot());
                }
            }
            int l3=ap_spots.size();
            for(int i=0;i<l3;i++){
                float num=interfaceServiceMapper.getSpotNum(ap_spots.get(i));
            total+=num/100;
        }
        }

            }
        return ResponseVO.buildSuccess(total);
        }
    public double getPaperHot(int paperId){
        //获得文章的热度
        try {
            double r=interfaceServiceMapper.getPaperHot(paperId);
            return r;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public ResponseVO getPaperRank(){
        //获得文章活跃度的排名
        List<PaperRank> PHs=interfaceServiceMapper.getPaperRank();
        for(int i=0;i<10;i++) {
            List<PaperInf> pis = interfaceServiceMapper.getInf(PHs.get(i).getPaperId());
            List<String> authors = new ArrayList<>();
            for(int j=0;j<pis.size();j++){
                //设置文章的作者们
               authors.add(testStr(pis.get(j).getAuthor()));
            }
            PaperRank pri=PHs.get(i);
            pri.setAuthors(authors);
            PHs.set(i,pri);
        }
        return ResponseVO.buildSuccess(PHs);
    }
    public ResponseVO LikePaper(int paperId){
        //用来获得与输入的文章相似的文章
        List<PaperSpot> ps = interfaceServiceMapper.getPaperSpot(paperId);
        List<String> origin_spots=new ArrayList<>();
        int l1 = ps.size();
        //先添加五个文章的领域
        if(l1>5)
            l1=5;
        for (int i = 0; i < l1; i++) {
            String spot=ps.get(i).getSpot().trim();
            if(!origin_spots.contains(spot)){
                origin_spots.add(spot);
            }
        }
        PaperInterfaceGet paper = new PaperInterfaceGet();
        int count = 0;
        int l2;
        //看领域是否相似来判断有没有相似的文章
        while(count<3) {
            List<PaperSpot> ps2 = new ArrayList<>();
            List<Integer> ids = new ArrayList<>();
            for(int i=0;i<origin_spots.size();i++) {
                int low_paperId=0;
                if(paperId>1000)
                    low_paperId=paperId-1000;
                ps2 = interfaceServiceMapper.getOtherPaper(low_paperId,paperId+1000, origin_spots.get(i));
                l2 = ps2.size();
                for (int j = 0; j < l2; j++) {
                    if (!ids.contains(ps2.get(j).getPaperId())) {
                        ids.add(ps2.get(j).getPaperId());
                        paper.addotherabs(ps2.get(j).getAbstracts());
                        paper.addotherPapers(ps2.get(j).getTitle());
                        paper.addotherpdf(ps2.get(j).getPdfLink());
                        paper.addids(ps2.get(j).getPaperId());
                        paper.addOtherTimes(ps2.get(j).getTime());
                        String author = interfaceServiceMapper.getAuthorName(ps2.get(j).getAuthorId());
                        paper.addOtherAuthors(testStr(author.trim()));
                        count++;
                        if(count==3)
                            break;
                    }
                }
                if(count==3)
                    break;
            }
            //如果文章不足够就从作者的别的文章里抽取
            if (count < 3) {
                int authorId = interfaceServiceMapper.getAuthorId(paperId).get(0);
                ps2 = interfaceServiceMapper.getPaperSpotByAuthor(paperId, authorId);
                l2 = ps2.size();
                System.out.println(l2);
                int c=count;
                for ( ;count <=3; count++) {
                    paper.addotherabs(ps2.get(count-c).getAbstracts());
                    paper.addotherPapers(ps2.get(count-c).getTitle());
                    paper.addotherpdf(ps2.get(count-c).getPdfLink());
                    paper.addids(ps2.get(count-c).getPaperId());
                    paper.addOtherTimes(ps2.get(count-c).getTime());
                    String author = interfaceServiceMapper.getAuthorName(ps2.get(count-c).getAuthorId());
                    paper.addOtherAuthors(testStr(author.trim()));
                }
            }
        }
        return ResponseVO.buildSuccess(paper);
    }
    public  String testStr(String s) {

        // 去除中文
        Pattern pat = Pattern.compile(REGEX_CHINESE);
        Matcher mat = pat.matcher(s);
        return mat.replaceAll("");
    }
    public List<String> listStr(List<String> a){
        //批量去除中文
        List<String> result=new ArrayList<>();
        int length=a.size();
        for(int i=0;i<length;i++){
            result.add(testStr(a.get(i)));
        }
        return  result;
    }
    }

