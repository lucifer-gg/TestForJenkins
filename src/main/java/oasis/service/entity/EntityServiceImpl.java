package oasis.service.entity;

import oasis.bl.entity.EntityService;
import oasis.data.entity.EntityMapper;
import oasis.data.mapping.MappingMapper;
import oasis.entity.entity.*;
import oasis.service.search.SearchServiceForBl;
import oasis.service.utils.UtilsServiceForBl;
import oasis.vo.BasicResponse;
import oasis.vo.ResponseStatus;
import oasis.vo.entity.*;
import oasis.vo.search.ArticleDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/04 14:21
 */
@Service
public class EntityServiceImpl implements EntityService {

    @Autowired
    private EntityMapper entityMapper;

    @Autowired
    private MappingMapper mappingMapper;

    @Autowired
    private SearchServiceForBl searchServiceForBl;

    @Autowired
    private UtilsServiceForBl utilsServiceForBl;

    /**
     * 检索作者
     *
     * @param authorName
     * @return
     */
    @Override
    public BasicResponse searchAuthor(String authorName) {
        try {
            List<AuthorSearchedPO> authorSearchedPOList = new ArrayList<>();
            List<AuthorSearchedPO> smartSearchRes = entityMapper.smartSearchAuthor(authorName);
            if (smartSearchRes.size() == 0) {
                List<AuthorSearchedPO> blurSearchRes = entityMapper.blurSearchAuthor(authorName);
                authorSearchedPOList.addAll(blurSearchRes);
            } else {
                authorSearchedPOList.addAll(smartSearchRes);
            }
            List<AuthorSearchedVO> authorSearchedVOList = new ArrayList<>();

            if (authorSearchedPOList.size() == 1 && isEmpty(authorSearchedPOList.get(0))) {
                authorSearchedVOList.add(new AuthorSearchedVO());
            } else {
                for (AuthorSearchedPO authorSearchedPO : authorSearchedPOList) {
                    List<Integer> articleIds = mappingMapper.getArtIdByAuthorId(authorSearchedPO.getAuthorId());
                    int reference = 0;
                    for (Integer articleId : articleIds) {
                        reference += entityMapper.getArticleReference(articleId);
                    }

                    AuthorSearchedVO authorSearchedVO = new AuthorSearchedVO(authorSearchedPO.getAuthorId(), authorSearchedPO.getAuthorName(), authorSearchedPO.getAffiliation(), reference, authorSearchedPO.getHindex());
                    authorSearchedVOList.add(authorSearchedVO);
                }
            }

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, authorSearchedVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 检索机构
     *
     * @param affiliationName
     * @return
     */
    @Override
    public BasicResponse searchAffiliation(String affiliationName) {
        try {
            List<AffiliationSearchedPO> affiliationPOList = new ArrayList<>();
            List<AffiliationSearchedPO> smartSearchRes = entityMapper.smartSearchAffiliation(affiliationName);
            if (smartSearchRes.size() == 0) {
                List<AffiliationSearchedPO> blurSearchRes = entityMapper.blurSearchAffiliation(affiliationName);
                affiliationPOList.addAll(blurSearchRes);
            } else {
                affiliationPOList.addAll(smartSearchRes);
            }
            List<AffiliationSearchedVO> affiliationVOList = new ArrayList<>();

            if (affiliationPOList.size() == 1 && isEmpty(affiliationPOList.get(0))) {
                affiliationVOList.add(new AffiliationSearchedVO());
            } else {
                for (AffiliationSearchedPO affiliationSearchedPO : affiliationPOList) {
                    int subAuthorNum = mappingMapper.getSubAuthorNum(affiliationSearchedPO.getAffiliationId());
                    List<Integer> articleIds = mappingMapper.getArtIdByAffiliationId(affiliationSearchedPO.getAffiliationId());
                    int totalArticle = articleIds.size();
                    int reference = 0;
                    for (Integer articleId : articleIds) {
                        reference += entityMapper.getArticleReference(articleId);
                    }

                    AffiliationSearchedVO affiliationSearchedVO = new AffiliationSearchedVO(affiliationSearchedPO.getAffiliationId(), affiliationSearchedPO.getAffiliationName(), subAuthorNum, totalArticle, reference);
                    affiliationVOList.add(affiliationSearchedVO);
                }
            }

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, affiliationVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 检索会议
     *
     * @param publicationTitle
     * @return
     */
    @Override
    public BasicResponse searchPublication(String publicationTitle) {
        try {
            List<PublicationSearchedPO> publicationSearchedPOList = entityMapper.searchPublication(publicationTitle);
            List<PublicationSearchedVO> publicationSearchedVOList = new ArrayList<>();

            if (publicationSearchedPOList.size() == 1 && isEmpty(publicationSearchedPOList.get(0))) {
                publicationSearchedVOList.add(new PublicationSearchedVO());
            } else {
                for (PublicationSearchedPO publicationSearchedPO : publicationSearchedPOList) {
                    List<Integer> articleIds = mappingMapper.getArtIdByPublicationId(publicationSearchedPO.getPublicationId());
                    int articleNum = articleIds.size();
                    int reference = 0;
                    for (Integer articleId : articleIds) {
                        reference += entityMapper.getArticleReference(articleId);
                    }

                    PublicationSearchedVO publicationSearchedVO = new PublicationSearchedVO(publicationSearchedPO.getPublicationId(), publicationSearchedPO.getPublicationTitle(), articleNum, reference, publicationSearchedPO.getHindex());
                    publicationSearchedVOList.add(publicationSearchedVO);
                }
            }

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, publicationSearchedVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 检索研究方向
     *
     * @param keyword
     * @return
     */
    @Override
    public BasicResponse searchKeyword(String keyword) {
        try {
            List<KeywordSearchedPO> keywordSearchedPOList = new ArrayList<>();
            List<KeywordSearchedPO> smartSearchRes = entityMapper.smartSearchKeyword(keyword);
            if (smartSearchRes.size() == 0) {
                List<KeywordSearchedPO> blurSearchRes = entityMapper.blurSearchKeyword(keyword);
                keywordSearchedPOList.addAll(blurSearchRes);
            } else {
                keywordSearchedPOList.addAll(smartSearchRes);
            }
            List<KeywordSearchedVO> keywordSearchedVOList = new ArrayList<>();

            if (keywordSearchedPOList.size() == 1 && isEmpty(keywordSearchedPOList.get(0))) {
                keywordSearchedVOList.add(new KeywordSearchedVO());
            } else {
                keywordSearchedPOList.stream().forEach(keywordSearchedPO -> {
                    keywordSearchedVOList.add(keywordSearchedPO.getKeywordSearchedVO());
                });
            }

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, keywordSearchedVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 查看作者画像
     *
     * @param authorId
     * @return
     */
    @Override
    public BasicResponse authorPortrait(int authorId) {
        try {
            AuthorPortraitPO authorPortraitPO = entityMapper.authorPortrait(authorId);
            List<Integer> articleIds = mappingMapper.getArtIdByAuthorId(authorId);
            // 当前研究方向
            List<String> keywords = new ArrayList<>();
            for (Integer docId : articleIds) {
                List<Integer> keywordIds = mappingMapper.getKeyWordsIdList(docId);
                for (Integer keyWordId : keywordIds) {
                    String keyword = mappingMapper.getKeyWordById(keyWordId);
                    keywords.add(keyword);
                }
            }
            keywords = utilsServiceForBl.removeDuplicate(keywords);
            // 所在机构
            List<String> affiliations = new ArrayList<>();
            for (Integer docId : articleIds) {
                List<Integer> affiliationIds = mappingMapper.getAffiliationIdList(docId);
                for (Integer affiliationId : affiliationIds) {
                    String affiliation = mappingMapper.getAffiliationById(affiliationId);
                    affiliations.add(affiliation);
                }
            }
            affiliations = utilsServiceForBl.removeDuplicate(affiliations);
            // ASE 和 ICSE 发表的论文数量
            String sqlList = utilsServiceForBl.listToSqlList(articleIds);
            Integer aseNum = mappingMapper.getAseNum(sqlList);
            Integer icseNum = mappingMapper.getIcseNum(sqlList);
            // 文章引用数量
            Integer reference = 0;
            for (Integer articleId : articleIds) {
                reference += entityMapper.getArticleReference(articleId);
            }

            AuthorPortraitVO authorPortraitVO = new AuthorPortraitVO(authorPortraitPO.getName(), authorPortraitPO.getHindex(), keywords, affiliations, aseNum, icseNum, reference, authorPortraitPO.getActivation());
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, authorPortraitVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 查看机构画像
     *
     * @param affiliationId
     * @return
     */
    @Override
    public BasicResponse affiliationPortrait(int affiliationId) {
        try {
            AffiliationPortraitPO affiliationPortraitPO = entityMapper.affiliationPortrait(affiliationId);
            int subAuthorNum = mappingMapper.getSubAuthorNum(affiliationId);
            List<Integer> articleIds = mappingMapper.getArtIdByAffiliationId(affiliationId);
            int articleNum = articleIds.size();
            int reference = 0;
            for (Integer articleId : articleIds) {
                reference += entityMapper.getArticleReference(articleId);
            }

            AffiliationPortraitVO affiliationPortraitVO = new AffiliationPortraitVO(affiliationPortraitPO.getAffiliationName(), subAuthorNum, articleNum, reference, affiliationPortraitPO.getActivation(), affiliationPortraitPO.getHindex());
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, affiliationPortraitVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 查看会议画像
     *
     * @param publicationTitle
     * @return
     */
    @Override
    public BasicResponse publicationPortrait(String publicationTitle) {
        try {
            Integer hindex = entityMapper.publicationPortrait(publicationTitle);
            String title;
            if ("ase".equals(publicationTitle)) {
                title = "International Conference on Automated Software Engineering";
            } else {
                title = "International Conference on Software Engineering";
            }

            List<Integer> publicationIds = mappingMapper.getPublicationIdsByType(publicationTitle);
            List<Integer> articleIds = new ArrayList<>();
            for (Integer publicationId : publicationIds) {
                List<Integer> partArticleId = mappingMapper.getArtIdByPublicationId(publicationId);
                articleIds.addAll(partArticleId);
            }
            // 论文数量
            int articleNum = articleIds.size();
            // 论文总引用数
            int reference = 0;
            for (Integer articleId : articleIds) {
                reference += entityMapper.getArticleReference(articleId);
            }

            PublicationPortraitVO publicationPortraitVO = new PublicationPortraitVO(title, articleNum, reference, hindex);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, publicationPortraitVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 查看研究方向画像
     *
     * @param keywordId
     * @return
     */
    @Override
    public BasicResponse keywordPortrait(int keywordId) {
        try {
            KeywordPortraitPO keywordPortraitPO = entityMapper.keywordPortrait(keywordId);
            List<Integer> articleIds = mappingMapper.getArtIdByKeywordId(keywordId);

            // 论文总引用数
            int reference = 0;
            for (Integer articleId : articleIds) {
                reference += entityMapper.getArticleReference(articleId);
            }

            KeywordPortraitVO keywordPortraitVO = new KeywordPortraitVO(keywordPortraitPO.getKeyword(), keywordPortraitPO.getArticleNum(), reference, keywordPortraitPO.getActivation());

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, keywordPortraitVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getRelatedAuthors(int authorId) {

        try{
            List<RelatedAuthorVO> relatedAuthorVOS =new ArrayList<>();
            relatedAuthorVOS.add(new RelatedAuthorVO("J. Penix",1,20));
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, relatedAuthorVOS);

        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 查看某机构下属作者信息
     *
     * @param affiliationId
     * @return
     */
    @Override
    public BasicResponse getSubAuthorsByAffiliation(int affiliationId) {
        try {
            List<SubAuthorPO> subAuthorPOList = mappingMapper.getSubAuthors(affiliationId);
            List<SubAuthorVO> subAuthorVOList = new ArrayList<>();

            for (SubAuthorPO subAuthorPO : subAuthorPOList) {
                List<Integer> articleIds = mappingMapper.getArtIdByAuthorId(subAuthorPO.getAuthorId());
                // 发表文章数量
                int articleNum = articleIds.size();
                // 文章引用数量
                int reference = 0;
                for (Integer articleId : articleIds) {
                    reference += entityMapper.getArticleReference(articleId);
                }
                SubAuthorVO subAuthorVO = new SubAuthorVO(subAuthorPO.getAuthorName(), subAuthorPO.getAuthorId(), articleNum, reference, subAuthorPO.getHindex(), subAuthorPO.getActivation());
                subAuthorVOList.add(subAuthorVO);
            }

            Collections.sort(subAuthorVOList, new Comparator<SubAuthorVO>() {
                @Override
                public int compare(SubAuthorVO arg0, SubAuthorVO arg1) {
                    int activation0 = arg0.getActivation();
                    int activation1 = arg1.getActivation();
                    if (activation1 > activation0) {
                        return 1;
                    } else if (activation1 == activation0) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            });

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, subAuthorVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 查看某作者的相关作者推荐
     *
     * @param curAuthorId
     * @return
     */
    @Override
    public BasicResponse recommendAuthors(int curAuthorId) {
        try {
            String strNeighbors = entityMapper.recommendAuthors(curAuthorId);
            List neighbors = utilsServiceForBl.strToList(strNeighbors);

            List<RelatedAuthorVO> relatedAuthors = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int authorId = Integer.parseInt((String) neighbors.get(i));

                RelatedAuthorVO relatedAuthor = new RelatedAuthorVO();
                relatedAuthor.setAuthorId(authorId);
                relatedAuthor.setAuthorName(mappingMapper.getAuthorById(authorId));
                List<Integer> authorDocs = mappingMapper.getArtIdByAuthorId(authorId);
                relatedAuthor.setArticleNum(authorDocs.size());

                relatedAuthors.add(relatedAuthor);
            }

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, relatedAuthors);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 根据作者编号查看文章详情
     *
     * @param authorId
     * @return
     */
    @Override
    public BasicResponse getArticlesByAuthor(int authorId) {
        try {
            List<Integer> authorArticles = mappingMapper.getArtIdByAuthorId(authorId);
            List<ArticleDetailVO> articleDetailVOList = new ArrayList<>();

            for (Integer articleId : authorArticles) {
                articleDetailVOList.add(searchServiceForBl.getArticleDetails(articleId));
            }

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleDetailVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 根据关键字编号查看文章详情
     *
     * @param keywordId
     * @return
     */
    @Override
    public BasicResponse getArticlesByKeyword(int keywordId) {
        try {
            List<Integer> keywordArticles = mappingMapper.getArtIdByKeywordId(keywordId);
            List<ArticleDetailVO> articleDetailVOList = new ArrayList<>();

            for (Integer articleId : keywordArticles) {
                articleDetailVOList.add(searchServiceForBl.getArticleDetails(articleId));
            }

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleDetailVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取各类实体的数目
     *
     * @return
     */
    @Override
    public BasicResponse getEntitiesNum() {
        try {
            EntitiesNumPO entitiesNumPO = entityMapper.getEntitiesNum();
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, entitiesNumPO.getEntitiesNumVO());
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 判断对象为空
     *
     * @param obj 对象名
     * @return 是否为空
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if ((obj instanceof List)) {
            return ((List) obj).size() == 0;
        }
        if ((obj instanceof String)) {
            return "".equals(((String) obj).trim());
        }
        return false;
    }

}
