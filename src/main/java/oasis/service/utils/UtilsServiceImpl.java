package oasis.service.utils;

import oasis.bl.utils.UtilsService;
import oasis.data.mapping.MappingMapper;
import oasis.vo.BasicResponse;
import oasis.vo.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
/**
 * @author cmw
 * @version 2.0
 * @date 2020/03/29 18:36
 */
public class UtilsServiceImpl implements UtilsService, UtilsServiceForBl {

    @Autowired
    MappingMapper mappingMapper;

    @Override
    public BasicResponse getKeyWordIdByName(String keyword) {
        try {
            int keyWordId = mappingMapper.getKeyWordIdByName(keyword);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, keyWordId);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);

        }
    }

    @Override
    public BasicResponse getPublicationIdByName(String name) {
        try {
            int pubId = mappingMapper.getPublicationIdByName(name);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, pubId);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);

        }
    }

    @Override
    public BasicResponse getAffiliationIdByName(String name) {
        try {
            int affID = mappingMapper.getAffiliationIdByName(name);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, affID);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 字符串以"*"分割为列表
     *
     * @param str
     * @return
     */
    @Override
    public List strToList(String str) {
        String[] array = str.split("\\*");
        List list = Arrays.asList(array);

        return list;
    }

    /**
     * 通过 HashSet 剔除列表内的冗余数据
     *
     * @param list
     * @return
     */
    @Override
    public List removeDuplicate(List list) {
        HashSet hashSet = new HashSet(list);
        list.clear();
        list.addAll(hashSet);
        return list;
    }

    /**
     * 列表转 SQL 列表
     *
     * @param list
     * @return
     */
    @Override
    public String listToSqlList(List list) {
        StringBuilder sqlList = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sqlList.append("'").append(list.get(i)).append("'");
            if (i != list.size() - 1) {
                sqlList.append(",");
            }
        }

        return sqlList.toString();
    }

    /**
     * 通过文章引用列表计算 H-Index
     *
     * @param citations
     * @return
     */
    @Override
    public int calHIndex(List<Integer> citations) {
        int n = citations.size();
        int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations.get(i) >= n) {
                // 统计引用数比总文章数还多的文章数目
                count[n]++;
            } else {
                // 统计每个引用次数下有多少篇文章
                count[citations.get(i)]++;
            }
        }
        if (count[n] >= n) {
            // 如果每篇文章的引用数都比文章数多，那H指数最多也只能是文章数n
            return n;
        }
        for (int i = n - 1; i >= 0; i--) {
            // 不要忘了这里的i一直是引用次数，所以这一步在统计大于等于i的文章总数，即逐个累加大于等于i的计数
            count[i] += count[i + 1];
            if (count[i] >= i) {
                // 一旦找到满足条件的引用次数，即返回
                return i;
            }
        }
        return 0;
    }

    private String percentBigDecimal(BigDecimal preNum, BigDecimal sufNum) {
        double result = countDecimal(preNum, sufNum);
        if (result > 0) {
            return "+" + result + "%";
        }
        if (result < 0) {
            return result + "%";
        }
        if (result == 0) {
            return "+" + 0 + "%";
        }
        return null;
    }

    private double countDecimal(BigDecimal preNum, BigDecimal sufNum) {
        boolean preBoolean = verifyNum(preNum);
        boolean sufBoolean = verifyNum(sufNum);
        // 同时为true计算
        if (preBoolean && sufBoolean) {
            if (verifyEqual(preNum, sufNum)) {
                return 0;
            } else {
                return realCountDecimal(preNum, sufNum);
            }
        }
        if (!preBoolean && !sufBoolean) {
            return 0;
        }
        if (!sufBoolean) {
            return 100;
        }
        return realCountDecimal(preNum, sufNum);
    }

    // 验证数字是否为零和null
    private boolean verifyNum(BigDecimal num) {
        if (null != num && num.compareTo(BigDecimal.ZERO) != 0) {
            return true;
        }
        return false;
    }

    // 验证两个数字是否相等
    private boolean verifyEqual(BigDecimal preNum, BigDecimal sufNum) {
        int n = preNum.compareTo(sufNum);
        // 比较 -1 小于   0 等于    1 大于
        if (n == 0) {
            return true;
        }
        return false;
    }

    // 真正计算
    private double realCountDecimal(BigDecimal preNum, BigDecimal sufNum) {
        // (前面的数字-后面的数字)/后面的数字*100
        BigDecimal bigDecimal = (preNum.subtract(sufNum)).divide(sufNum, 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_UP);
        if (bigDecimal.compareTo(BigDecimal.ZERO) != 0) {
            return bigDecimal.doubleValue();
        }
        return 0;
    }

    /**
     * 计算百分比
     *
     * @param former
     * @param later
     * @return
     */
    @Override
    public String percentCount(int former, int later) {
        BigDecimal num1 = new BigDecimal(Integer.toString(former));
        BigDecimal num2 = new BigDecimal(Integer.toString(later));
        return percentBigDecimal(num1, num2);
    }

}
