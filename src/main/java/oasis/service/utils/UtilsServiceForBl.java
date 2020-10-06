package oasis.service.utils;

import java.util.List;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/31 17:07
 */
public interface UtilsServiceForBl {

    /**
     * 字符串以"*"分割为列表
     *
     * @param str
     * @return
     */
    List strToList(String str);

    /**
     * 通过 HashSet 剔除列表内的冗余数据
     *
     * @param list
     * @return
     */
    List removeDuplicate(List list);

    /**
     * 列表转 SQL 列表
     *
     * @param list
     * @return
     */
    String listToSqlList(List list);

    /**
     * 通过文章引用列表计算 H-Index
     *
     * @param citations
     * @return
     */
    int calHIndex(List<Integer> citations);

    /**
     * 计算百分比
     *
     * @param former
     * @param later
     * @return
     */
    String percentCount(int former, int later);

}
