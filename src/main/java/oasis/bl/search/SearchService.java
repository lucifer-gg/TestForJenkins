package oasis.bl.search;

import oasis.parameter.search.SearchParam;
import oasis.vo.BasicResponse;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/04 08:07
 */
public interface SearchService {

    /**
     * 通过作者、机构、会议、研究关键词、或时间及其组合搜索检索内容
     *
     * @param searchParam
     * @return
     */
    BasicResponse getArtItem(SearchParam searchParam);

    /**
     * 通过文章编号检索文章详细内容
     *
     * @param articleId
     * @return
     */
    BasicResponse getArtDetailById(int articleId);

}
