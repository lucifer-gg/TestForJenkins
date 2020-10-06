package oasis.service.rank;

import oasis.bl.rank.RankService;
import oasis.data.chart.ChartMapper;
import oasis.data.mapping.MappingMapper;
import oasis.data.rank.RankMapper;
import oasis.data.search.SearchMapper;
import oasis.entity.chart.AnnualArticlePO;
import oasis.entity.rank.*;
import oasis.service.utils.UtilsServiceForBl;
import oasis.vo.BasicResponse;
import oasis.vo.ResponseStatus;
import oasis.vo.rank.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.*;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/04 14:21
 */
@Service
public class RankServiceImpl implements RankService {

    @Autowired
    private RankMapper rankMapper;

    @Autowired
    private ChartMapper chartMapper;

    @Autowired
    private SearchMapper searchMapper;

    @Autowired
    private MappingMapper mappingMapper;

    @Autowired
    private UtilsServiceForBl utilsServiceForBl;

    /**
     * 获取论文数量前5的作者
     *
     * @return
     */
    @Override
    public BasicResponse getTopAuthors() {
        try {
            List<RankAuthorPO> topAuthorsPO = rankMapper.getTopAuthors();

            List<AuthorVO> topAuthorsVO = new ArrayList<>();
            for (RankAuthorPO topAuthorPO : topAuthorsPO) {
                AuthorVO authorVO = new AuthorVO(topAuthorPO.getAuthorName(), topAuthorPO.getAuthorId(), topAuthorPO.getArticleNum());
                topAuthorsVO.add(authorVO);
            }

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, topAuthorsVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取被引用量前5的文章
     *
     * @return
     */
    @Override
    public BasicResponse getTopReferences() {
        try {
            List<RankArticlePO> topArticlesPO = rankMapper.getTopReferences();

            List<ArticleVO> topArticlesVO = new ArrayList<>();
            topArticlesPO.stream().forEach(topArticlePO -> {
                ArticleVO articleVO = new ArticleVO(topArticlePO.getDocTitle(), topArticlePO.getDocId(), topArticlePO.getReference());
                topArticlesVO.add(articleVO);
            });

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, topArticlesVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取搜索次数前5的关键字
     *
     * @return
     */
    @Override
    public BasicResponse getTopKeyWords() {
        try {
            List<RankKeyWordPO> topKeyWordsPO = rankMapper.getTopKeyWords();

            List<KeyWordsVO> topKeyWordsVO = new ArrayList<>();
            topKeyWordsPO.stream().forEach(topKeyWordPO -> {
                KeyWordsVO keyWordsVO = new KeyWordsVO(topKeyWordPO.getKeyWordsId(), topKeyWordPO.getKeyWords(), topKeyWordPO.getKeyWordsSearchTime());
                topKeyWordsVO.add(keyWordsVO);
            });

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, topKeyWordsVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取 ASE 会议上发表论文数量前5的机构
     *
     * @return
     */
    @Override
    public BasicResponse getAseTopAffiliations() {
        try {
            List<RankAffiliationPO> topAffiliationsPO = rankMapper.getAseTopAffiliations();

            List<AffiliationVO> topAffiliationsVO = new ArrayList<>();
            topAffiliationsPO.stream().forEach(topAffiliationPO -> {
                AffiliationVO affiliationVO = new AffiliationVO(topAffiliationPO.getAffiliationName(), topAffiliationPO.getAffiliationId(), topAffiliationPO.getArticleNum());
                topAffiliationsVO.add(affiliationVO);
            });

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, topAffiliationsVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取 ICSE 会议上发表论文数量前5的机构
     *
     * @return
     */
    @Override
    public BasicResponse getIcseTopAffiliations() {
        try {
            List<RankAffiliationPO> topAffiliationsPO = rankMapper.getIcseTopAffiliations();

            List<AffiliationVO> topAffiliationsVO = new ArrayList<>();
            topAffiliationsPO.stream().forEach(topAffiliationPO -> {
                AffiliationVO affiliationVO = new AffiliationVO(topAffiliationPO.getAffiliationName(), topAffiliationPO.getAffiliationId(), topAffiliationPO.getArticleNum());
                topAffiliationsVO.add(affiliationVO);
            });

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, topAffiliationsVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getTopKeyWordByActivation() {
        try {
            List<RankKeyWordByActivationPO> topKeyWordByActivationList = rankMapper.getTopKeyWordByActivation();
            List<KeyWordByActivationVO> keyWordByActivationVOList = new ArrayList<>();
            for (RankKeyWordByActivationPO po : topKeyWordByActivationList) {
                keyWordByActivationVOList.add(new KeyWordByActivationVO(po.getKeyWord(), po.getKeyWordId(), po.getKeyWordActivation()));
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, keyWordByActivationVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getTopAuthorByActivation() {

        try {
            List<RankAuthorByActivationPO> rankAuthorByActivationPOList = rankMapper.getTopAuthorByActivation();
            List<AuthorByActivationVO> authorByActivationVOList = new ArrayList<>();
            for (RankAuthorByActivationPO po : rankAuthorByActivationPOList) {
                authorByActivationVOList.add(new AuthorByActivationVO(po.getAuthorName(), po.getAuthorId(), po.getAuthorActivation()));
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, authorByActivationVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }

    }

    private Map<Integer, Integer> frequencyOfListElements(List<Integer> items) {
        if (items == null || items.size() == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int temp : items) {
            Integer count = map.get(temp);
            map.put(temp, (count == null) ? 1 : count + 1);
        }
        return map;
    }

    @Override
    public BasicResponse getTopAffiliationByActivation() {
        try {
            List<RankAffiliationByActivationPO> rankAffiliationByActivationPOList = rankMapper.getTopAffiliationByActivation();
            List<AffiliationByActivationVO> affiliationByActivationVOList = new ArrayList<>();
            for (RankAffiliationByActivationPO po : rankAffiliationByActivationPOList) {
                affiliationByActivationVOList.add(new AffiliationByActivationVO(po.getAffiliationName(), po.getAffiliationId(), po.getAffiliationActivation()));
            }

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, affiliationByActivationVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getTopAuthorByKeyword(int keywordId) {
        try {
            ArrayList authorList = new ArrayList();
            String keyWord = mappingMapper.getKeyWordById(keywordId);
            List<Integer> docIdList = searchMapper.getDocIdByTheKeyWord(keyWord);
            List<Integer> authorListPerArticle = null;
            for (int i = 0; i < docIdList.size(); i++) {
                authorListPerArticle = mappingMapper.getAuthorsIdList(docIdList.get(i));
                for (int j = 0; j < authorListPerArticle.size(); j++) {
                    authorList.add(authorListPerArticle.get(j));
                }
            }
            Map<Integer, Integer> resMap = frequencyOfListElements(authorList);

            List<Map.Entry<Integer, Integer>> resList = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry : resMap.entrySet()) {
                resList.add(entry); //将map中的元素放入list中
            }

            resList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });

            List<AuthorByKeywordVO> authorByKeywordVOList = new ArrayList<>();

            int count = 0;
            for (Map.Entry<Integer, Integer> entry : resList) {
                if (count == 10) {
                    break;
                }
                int authorId = entry.getKey();
                String authorName = mappingMapper.getAuthorById(authorId);
                authorByKeywordVOList.add(new AuthorByKeywordVO(authorId, authorName));
                count++;
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, authorByKeywordVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getTopAffilicationByKeyword(int keywordId) {
        try {
            ArrayList affiliationList = new ArrayList();
            String keyWord = mappingMapper.getKeyWordById(keywordId);
            List<Integer> docIdList = searchMapper.getDocIdByTheKeyWord(keyWord);
            List<Integer> affiliationListPerArticle = null;
            for (int i = 0; i < docIdList.size(); i++) {
                affiliationListPerArticle = mappingMapper.getAffiliationIdList(docIdList.get(i));
                for (int j = 0; j < affiliationListPerArticle.size(); j++) {
                    affiliationList.add(affiliationListPerArticle.get(j));
                }
            }
            Map<Integer, Integer> resMap = frequencyOfListElements(affiliationList);

            List<Map.Entry<Integer, Integer>> resList = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry : resMap.entrySet()) {
                resList.add(entry); //将map中的元素放入list中
            }

            resList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });

            List<AffiliationByKeywordVO> affiliationByKeywordVOList = new ArrayList<>();
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : resList) {
                if (count == 10) {
                    break;
                }
                int affiliationId = entry.getKey();
                String affiliationName = mappingMapper.getAffiliationById(affiliationId);
                if (affiliationName.equals("NA")) {
                    continue;
                }
                affiliationByKeywordVOList.add(new AffiliationByKeywordVO(affiliationName, affiliationId));
                count++;
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, affiliationByKeywordVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 热点趋势分析
     *
     * @return
     */
    @Override
    public BasicResponse analysisTopKeyword() {
        try {
            List<HotTrendPO> hotTrendPOList = rankMapper.getHotTrends();
            int totalArticleNum = searchMapper.getAllDocId().size();

            List<HotTrendVO> hotTrendVOList = new ArrayList<>();
            List<String> yearList = mappingMapper.getYearList();
            Collections.sort(yearList);
            yearList.remove(0);
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setMaximumFractionDigits(2);

            for (HotTrendPO hotTrendPO : hotTrendPOList) {
                String radio = numberFormat.format((float) hotTrendPO.getArticleNum() / (float) totalArticleNum * 100) + "%";

                List<Integer> activationPerYear = new ArrayList<>();
                for (int i = 0; i < yearList.size(); i++) {
                    String year = yearList.get(i);
                    List<Integer> docIdList = mappingMapper.getDocIdListByKeywordAndYear(hotTrendPO.getKeyword(), year);
                    List refList = new ArrayList();
                    for (int j = 0; j < docIdList.size(); j++) {
                        refList.add(mappingMapper.getReferenceByDocId(docIdList.get(j)));
                    }
                    int hindex = utilsServiceForBl.calHIndex(refList);
                    activationPerYear.add(hindex);
                }

                List<String> percentList = new ArrayList<>();
                int yearNum = yearList.size();
                for (int i = 0; i < yearNum - 1; i++) {
                    int former = activationPerYear.get(i);
                    int later = activationPerYear.get(i + 1);
                    String incPercent = utilsServiceForBl.percentCount(former, later);
                    percentList.add(incPercent);
                }

                HotTrendVO hotTrendVO = new HotTrendVO(hotTrendPO.getKeywordId(), hotTrendPO.getKeyword(), radio, percentList);
                hotTrendVOList.add(hotTrendVO);
            }

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, hotTrendVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

}
