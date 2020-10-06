package oasis.bl.utils;


import oasis.vo.BasicResponse;

/**
 * @author cmw
 * @version 2.1
 * @date 2020/03/29 18:31
 */
public interface UtilsService {
    /**
     * 通过关键字内容获取关键字id
     */

    BasicResponse getKeyWordIdByName(String keyword);

    BasicResponse getPublicationIdByName(String name);

    BasicResponse getAffiliationIdByName(String name);

}
