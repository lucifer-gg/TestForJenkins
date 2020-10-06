package oasis.service.chart;

import oasis.bl.chart.ChartService;
import oasis.data.chart.ChartMapper;
import oasis.data.mapping.MappingMapper;
import oasis.data.search.SearchMapper;
import oasis.entity.chart.AnnualArticlePO;
import oasis.entity.chart.AuthorNodePO;
import oasis.entity.chart.HinderPerYearPO;
import oasis.entity.chart.KeywordDistPO;
import oasis.service.utils.UtilsServiceForBl;
import oasis.vo.BasicResponse;
import oasis.vo.ResponseStatus;
import oasis.vo.chart.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.*;

/**
 * @author cmw
 * @version 2.0
 * @date 2020/03/30 21:45
 */

@Service
public class ChartServiceImpl implements ChartService {

    @Autowired
    private ChartMapper chartMapper;

    @Autowired
    private MappingMapper mappingMapper;

    @Autowired
    private SearchMapper searchMapper;

    @Autowired
    private UtilsServiceForBl utilsServiceForBl;

    private Map<String, Integer> frequencyOfListElements(List<String> items) {
        if (items == null || items.size() == 0) {
            return null;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String temp : items) {
            Integer count = map.get(temp);
            map.put(temp, (count == null) ? 1 : count + 1);
        }
        return map;
    }

    @Override
    public BasicResponse getArticlePerYearByKeyword(int keywordId) {
        try {
            String keyword = mappingMapper.getKeyWordById(keywordId);
            List<Integer> docIdList = searchMapper.getDocIdByTheKeyWord(keyword);
            List<String> yearList = new ArrayList<>();
            for (int i = 0; i < docIdList.size(); i++) {
                String year = mappingMapper.getDocYearByDocId(docIdList.get(i));
                yearList.add(year);
            }
            Map<String, Integer> resMap = frequencyOfListElements(yearList);

            List<String> docYearList=mappingMapper.getYearList();
            for(int i=0;i<docYearList.size();i++){
                Integer count=resMap.get(docYearList.get(i));
                resMap.put(docYearList.get(i),(count==null)?0:count);
            }


            List<Map.Entry<String, Integer>> resList = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : resMap.entrySet()) {
                resList.add(entry); //将map中的元素放入list中
            }

            resList.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return Integer.parseInt(o1.getKey()) - Integer.parseInt(o2.getKey());
                }
            });

            ArrayList<String> resYearList = new ArrayList();
            ArrayList<Integer> articleNumList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : resList) {
                resYearList.add(entry.getKey());
                articleNumList.add(entry.getValue());
            }

            ArticlePerYearByKeywordVO articlePerYearByKeywordVO = new ArticlePerYearByKeywordVO(resYearList, articleNumList);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articlePerYearByKeywordVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getReferencePerYearByPublication(String publicationTitle) {
        try {
            Map<String, Integer> map = new HashMap<String, Integer>();
            List<Integer> docIdList = searchMapper.getDocIdByPublicName(publicationTitle);
            for (int i = 0; i < docIdList.size(); i++) {
                int docId = docIdList.get(i);
                String year = mappingMapper.getDocYearByDocId(docId);
                int reference = mappingMapper.getReferenceByDocId(docId);
                Integer count = map.get(year);
                map.put(year, (count == null) ? reference : count + reference);
            }


            List<Map.Entry<String, Integer>> resList = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                resList.add(entry); //将map中的元素放入list中
            }

            resList.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return Integer.parseInt(o1.getKey()) - Integer.parseInt(o2.getKey());
                }
            });

            ArrayList<String> resYearList = new ArrayList();
            ArrayList<Integer> referenceList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : resList) {
                resYearList.add(entry.getKey());
                referenceList.add(entry.getValue());
            }

            ReferencePerYearByPublicationVO referencePerYearByPublicationVO = new ReferencePerYearByPublicationVO(resYearList, referenceList);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, referencePerYearByPublicationVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getHindexPerYearByPublication(String publicationTitle) {
        try {
            Map<String, Integer> map = new HashMap<>();
            publicationTitle = publicationTitle.toLowerCase();
            List<HinderPerYearPO> hinderPerYearPOList = chartMapper.getHindexPerYearByTitle(publicationTitle);
            for (HinderPerYearPO po : hinderPerYearPOList) {
                map.put(po.getPublicationYear(), po.getHindex());
            }



            List<Map.Entry<String, Integer>> resList = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                resList.add(entry); //将map中的元素放入list中
            }

            resList.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return Integer.parseInt(o1.getKey()) - Integer.parseInt(o2.getKey());
                }
            });
            List<String> resYearList = new ArrayList<>();
            List<Integer> resHindexList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : resList) {
                resYearList.add(entry.getKey());
                resHindexList.add(entry.getValue());
            }

            HindexPerYearByPublicationVO hindexPerYearByPublicationVO = new HindexPerYearByPublicationVO(resYearList, resHindexList);

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, hindexPerYearByPublicationVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getArticlePerYearByPublication(String publicationTitle) {
        try {
            Map<String, Integer> map = new HashMap<String, Integer>();
            List<Integer> docIdList = searchMapper.getDocIdByPublicName(publicationTitle);
            for (int i = 0; i < docIdList.size(); i++) {
                int docId = docIdList.get(i);
                String year = mappingMapper.getDocYearByDocId(docId);
                Integer count = map.get(year);
                map.put(year, (count == null) ? 1 : count + 1);
            }

            List<Map.Entry<String, Integer>> resList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                resList.add(entry); //将map中的元素放入list中
            }

            resList.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return Integer.parseInt(o1.getKey()) - Integer.parseInt(o2.getKey());
                }
            });

            ArrayList<String> resYearList = new ArrayList();
            ArrayList<Integer> resNumList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : resList) {
                resYearList.add(entry.getKey());
                resNumList.add(entry.getValue());
            }

            ArticlePerYearByPublicationVO articlePerYearByPublicationVO = new ArticlePerYearByPublicationVO(resYearList, resNumList);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articlePerYearByPublicationVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getTopKeywordByPublication(String publicationTitle) {
        try {
            List<Integer> docIdList = searchMapper.getDocIdByPublicName(publicationTitle);
            List<String> keywordListForCal = new ArrayList<>();
            for (int i = 0; i < docIdList.size(); i++) {
                int docId = docIdList.get(i);
                List<Integer> keywordIdList = mappingMapper.getKeyWordsIdList(docId);
                for (int j = 0; j < keywordIdList.size(); j++) {
                    String keyword = mappingMapper.getKeyWordById(keywordIdList.get(j));
                    keywordListForCal.add(keyword);
                }
            }

            Map<String, Integer> resMap = frequencyOfListElements(keywordListForCal);

            List<Map.Entry<String, Integer>> resList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : resMap.entrySet()) {
                resList.add(entry); //将map中的元素放入list中
            }


            resList.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });

            TopKeywordByPublicationVO topKeywordByPublicationVO = new TopKeywordByPublicationVO(resList.get(0).getKey(), resList.get(1).getKey(), resList.get(2).getKey(), resList.get(3).getKey(), resList.get(4).getKey());
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, topKeywordByPublicationVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 查看某作者每年发表的文章数量
     *
     * @param authorId
     * @return
     */
    @Override
    public BasicResponse getAuthorAnnualArticle(int authorId) {
        try {
            List<Integer> articleIds = mappingMapper.getArtIdByAuthorId(authorId);
            List<AnnualArticlePO> annualArticlePOList = chartMapper.getAnnualArticles(utilsServiceForBl.listToSqlList(articleIds));
            List<String> yearList = mappingMapper.getYearList();
            Collections.sort(yearList);

            AnnualArticleVO annualArticleVO = new AnnualArticleVO();
            yearList.stream().forEach(year -> {
                annualArticleVO.addYearList(year);
                annualArticleVO.addArticleNumList(0);
            });
            annualArticlePOList.stream().forEach(annualArticlePO -> {
                annualArticleVO.setArticleNum(annualArticlePO.getYear(), annualArticlePO.getArticleNum());
            });

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, annualArticleVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 查看某机构每年发表的文章数量
     *
     * @param affiliationId
     * @return
     */
    @Override
    public BasicResponse getAffiliationAnnualArticle(int affiliationId) {
        try {
            List<Integer> articleIds = mappingMapper.getArtIdByAffiliationId(affiliationId);
            List<AnnualArticlePO> annualArticlePOList = chartMapper.getAnnualArticles(utilsServiceForBl.listToSqlList(articleIds));
            List<String> yearList = mappingMapper.getYearList();
            Collections.sort(yearList);

            AnnualArticleVO annualArticleVO = new AnnualArticleVO();
            yearList.stream().forEach(year -> {
                annualArticleVO.addYearList(year);
                annualArticleVO.addArticleNumList(0);
            });
            annualArticlePOList.stream().forEach(annualArticlePO -> {
                annualArticleVO.setArticleNum(annualArticlePO.getYear(), annualArticlePO.getArticleNum());
            });

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, annualArticleVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 查看某机构研究方向的分布
     *
     * @param affiliationId
     * @return
     */
    @Override
    public BasicResponse getKeywordDistribution(int affiliationId) {
        try {
            List<Integer> articleIds = mappingMapper.getArtIdByAffiliationId(affiliationId);
            List<Integer> keywordIds = new ArrayList<>();
            for (Integer docId : articleIds) {
                keywordIds.addAll(mappingMapper.getKeyWordsIdList(docId));
            }
            keywordIds = utilsServiceForBl.removeDuplicate(keywordIds);
            KeywordDistVO keywordDistVO = new KeywordDistVO();

            if (keywordIds.size() != 0) {
                List<KeywordDistPO> keywordDistPOList = chartMapper.getKeywordDist(utilsServiceForBl.listToSqlList(keywordIds));

                Integer count = 0;
                for (KeywordDistPO keywordDistPO : keywordDistPOList) {
                    count += keywordDistPO.getArticleNum();
                }
                Integer articles = count;

                NumberFormat numberFormat = NumberFormat.getInstance();
                numberFormat.setMaximumFractionDigits(2);
                keywordDistPOList.stream().forEach(keywordDistPO -> {
                    Integer articleNum = keywordDistPO.getArticleNum();
                    keywordDistVO.addKeywordList(keywordDistPO.getKeyword());
                    keywordDistVO.addArticleNumList(articleNum);
                    keywordDistVO.addPercentList(numberFormat.format((float) articleNum / (float) articles * 100) + "%");
                });
            }

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, keywordDistVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 查看某机构每年的H-Index
     *
     * @param affiliationId
     * @return
     */
    @Override
    public BasicResponse getAffiliationAnnualHindex(int affiliationId) {
        try {
            List<Integer> articleIds = mappingMapper.getArtIdByAffiliationId(affiliationId);
            List<String> publishYears = new ArrayList<>();
            for (Integer docId : articleIds) {
                publishYears.add(mappingMapper.getDocYearByDocId(docId));
            }
            publishYears = utilsServiceForBl.removeDuplicate(publishYears);

            List<Integer> hindexs = new ArrayList<>();
            for (String year : publishYears) {
                List<Integer> references = new ArrayList<>();
                for (Integer articleId :articleIds) {
                    int reference = mappingMapper.getAffiliationAnnualRef(year, articleId);
                    references.add(reference);
                }
                int hindex = utilsServiceForBl.calHIndex(references);
                hindexs.add(hindex);
            }

            List<String> yearList = mappingMapper.getYearList();
            Collections.sort(yearList);
            List<Integer> hindexList = new ArrayList<>(Collections.nCopies(yearList.size(), 0));

            AnnualHindexVO annualHindexVO = new AnnualHindexVO();
            annualHindexVO.setYearList(yearList);
            annualHindexVO.setHindexList(hindexList);
            int size = publishYears.size();
            for (int i = 0; i < size; i++) {
                annualHindexVO.setHindex(publishYears.get(i), hindexs.get(i));
            }

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, annualHindexVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getRefPerYearBykeyword(int keywordId) {
        try {
            Map<String, Integer> map = new HashMap<String, Integer>();
            String keyword=mappingMapper.getKeyWordById(keywordId);
            List<Integer> docIdList = searchMapper.getDocIdByTheKeyWord(keyword);
            for (int i = 0; i < docIdList.size(); i++) {
                int docId = docIdList.get(i);
                String year = mappingMapper.getDocYearByDocId(docId);
                int reference = mappingMapper.getReferenceByDocId(docId);
                Integer count = map.get(year);
                map.put(year, (count == null) ? reference : count + reference);
            }

            List<String> docYearList=mappingMapper.getYearList();
            for(int i=0;i<docYearList.size();i++){
                Integer count=map.get(docYearList.get(i));
                map.put(docYearList.get(i),(count==null)?0:count);
            }

            List<Map.Entry<String, Integer>> resList = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                resList.add(entry); //将map中的元素放入list中
            }

            resList.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return Integer.parseInt(o1.getKey()) - Integer.parseInt(o2.getKey());
                }
            });

            ArrayList<String> resYearList = new ArrayList();
            ArrayList<Integer> referenceList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : resList) {
                resYearList.add(entry.getKey());
                referenceList.add(entry.getValue());
            }

            RefPerYearBykeywordVO refPerYearBykeywordVO=new RefPerYearBykeywordVO(resYearList,referenceList);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,refPerYearBykeywordVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getHindexPerYearByKeyword(int keywordId) {
        try {
            Map<String,Integer> resmap=new HashMap<>();
            String keyword=mappingMapper.getKeyWordById(keywordId);
            List<String> yearList=mappingMapper.getYearList();
            for (int i=0;i<yearList.size();i++){
                String year=yearList.get(i);
                List<Integer> docIdList=mappingMapper.getDocIdListByKeywordAndYear(keyword,year);
                List refList=new ArrayList();
                for (int j=0;j<docIdList.size();j++){
                    refList.add(mappingMapper.getReferenceByDocId(docIdList.get(j)));
                }
                int hindex=utilsServiceForBl.calHIndex(refList);
                if (hindex!=0)
                    resmap.put(year,hindex);
            }

            List<String> docYearList=mappingMapper.getYearList();
            for(int i=0;i<docYearList.size();i++){
                Integer count=resmap.get(docYearList.get(i));
                resmap.put(docYearList.get(i),(count==null)?0:count);
            }

            List<Map.Entry<String, Integer>> resList = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : resmap.entrySet()) {
                resList.add(entry); //将map中的元素放入list中
            }

            resList.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return Integer.parseInt(o1.getKey()) - Integer.parseInt(o2.getKey());
                }
            });

            ArrayList<String> resYearList = new ArrayList();
            ArrayList<Integer> resHindexList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : resList) {
                resYearList.add(entry.getKey());
                resHindexList.add(entry.getValue());
            }

            HindexPerYearByKeywordVO hindexPerYearByKeywordVO=new HindexPerYearByKeywordVO(resYearList,resHindexList);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,hindexPerYearByKeywordVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getReferencePerYearByAuthor(int authorId) {
        try{
            String authorName=mappingMapper.getAuthorById(authorId);
            List<Integer> docIdList=searchMapper.getDocIdByTheAuthor(authorName);
            Map<String, Integer> map = new HashMap<String, Integer>();
            for (int i = 0; i < docIdList.size(); i++) {
                int docId = docIdList.get(i);
                String year = mappingMapper.getDocYearByDocId(docId);
                int reference = mappingMapper.getReferenceByDocId(docId);
                if (reference!=0) {
                    Integer count = map.get(year);
                    map.put(year, (count == null) ? reference : count + reference);
                }
            }


            List<String> docYearList=mappingMapper.getYearList();
            for(int i=0;i<docYearList.size();i++){
                Integer count=map.get(docYearList.get(i));
                map.put(docYearList.get(i),(count==null)?0:count);
            }

            List<Map.Entry<String, Integer>> resList = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                resList.add(entry); //将map中的元素放入list中
            }

            resList.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return Integer.parseInt(o1.getKey()) - Integer.parseInt(o2.getKey());
                }
            });

            ArrayList<String> resYearList = new ArrayList();
            ArrayList<Integer> referenceList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : resList) {
                resYearList.add(entry.getKey());
                referenceList.add(entry.getValue());
            }

            RefPerYearByAuthor refPerYearByAuthor=new RefPerYearByAuthor(resYearList,referenceList);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,refPerYearByAuthor);

        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取作者链接图所需数据
     *
     * @param curAuthorId
     * @return
     */
    @Override
    public BasicResponse getLinkedDataByAuthor(int curAuthorId) {
        try {
            List<Integer> linkedAuthorIds = chartMapper.getLinkedAuthors(curAuthorId);
            List<Integer> coopCounts = chartMapper.getCoopCounts(curAuthorId);

            LinkedDataByAuthorVO linkedDataByAuthorVO = new LinkedDataByAuthorVO();
            AuthorNodePO curAuthorNodePO = chartMapper.getAuthorNodeInfo(curAuthorId);
            linkedDataByAuthorVO.addNode(curAuthorNodePO.getName(), curAuthorNodePO.getSymbolSize(), curAuthorId);
            int size = linkedAuthorIds.size();
            for (int i = 0; i < size; i++) {
                int authorId = linkedAuthorIds.get(i);
                AuthorNodePO otsAuthorNodePO = chartMapper.getAuthorNodeInfo(authorId);
                linkedDataByAuthorVO.addNode(otsAuthorNodePO.getName(), otsAuthorNodePO.getSymbolSize(), authorId);
                linkedDataByAuthorVO.addEdge(coopCounts.get(i), curAuthorId, authorId);
            }

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, linkedDataByAuthorVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取全局作者链接图所需数据
     *
     * @return
     */
    @Override
    public BasicResponse getTotalAuthorLinkedData() {
        try {
            List<Integer> authors = mappingMapper.getAllAuthorIds();
            boolean[] ifRecorded = new boolean[authors.size()];
            LinkedDataByAuthorVO linkedDataByAuthorVO = new LinkedDataByAuthorVO();

            for (Integer authorId : authors) {
                AuthorNodePO authorNodePO = chartMapper.getAuthorNodeInfo(authorId);
                linkedDataByAuthorVO.addNode(authorNodePO.getName(), authorNodePO.getSymbolSize(), authorId);
            }
            for (Integer curAuthorId : authors) {
                List<Integer> linkedAuthorIds = chartMapper.getLinkedAuthors(curAuthorId);
                List<Integer> coopCounts = chartMapper.getCoopCounts(curAuthorId);

                int size = linkedAuthorIds.size();
                for (int i = 0; i < size; i++) {
                    int authorId = linkedAuthorIds.get(i);
                    if (!ifRecorded[authorId - 1]) {
                        linkedDataByAuthorVO.addEdge(coopCounts.get(i), curAuthorId, authorId);
                    }
                }

                ifRecorded[curAuthorId - 1] = true;
            }

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, linkedDataByAuthorVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

}
