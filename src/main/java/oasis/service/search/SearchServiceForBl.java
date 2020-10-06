package oasis.service.search;

import oasis.vo.search.ArticleDetailVO;

import java.util.List;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/04/10 18:39
 */
public interface SearchServiceForBl {

    /**
     * 根据文章编号获取其详细信息
     *
     * @param docId
     * @return
     */
    ArticleDetailVO getArticleDetails(int docId);

}
