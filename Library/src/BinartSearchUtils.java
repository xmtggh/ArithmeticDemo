import java.util.List;

/**
 * 二分法搜索的工具类
 */
public class BinartSearchUtils {

    /**
     * 二分法查找数组关键字小标
     *
     * @param array 源数组，必须按照某种条件排序
     * @param key   查找关键字
     * @param c     排序条件
     * @param <T>   查找数组类型
     * @return
     */
    public static <T> int bindSerch(List<T> array, T key, Condition<? super T> c) {
        if (array == null || key == null || c == null) {
            throw new IllegalStateException("您输入的参数异常！");
        }
        if (array.size() <1){
            throw new IllegalStateException("空数组");
        }
        if (!checkSource(array, c)) {
            throw new IllegalStateException("无法为您的数组排序，请确认数组是否按照某一条件顺序排序");
        }
        int startIndex = 0;
        int midIndex = -1;
        int endIndex = array.size() - 1;
        while (startIndex <= endIndex) {
            midIndex = (endIndex - startIndex) / 2 + startIndex;
            int resulte = c.compare(key, array.get(midIndex));
            if (resulte < 0) {
                endIndex = midIndex - 1;
            } else if (resulte > 0) {
                startIndex = midIndex + 1;
            } else {
                return midIndex;
            }
        }
        return -1;
    }

    /**
     * 检查数组是否按照某一条件排序
     *
     * @param array
     * @param c
     * @param <T>
     * @return
     */
    private static <T> boolean checkSource(List<T> array, Condition<? super T> c) {
        for (int i = 0; i < array.size() - 2; i++) {
            boolean frist = c.compare(array.get(i), array.get(i + 1)) > 0;
            boolean second = c.compare(array.get(i + 1), array.get(i + 2)) > 0;
            if (frist != second) {
                return false;
            }
        }
        return true;
    }

}
