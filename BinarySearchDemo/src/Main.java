import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    /**
     * 二分查找算法是在某一组数据中快速查找的算法
     *
     * @param args
     */
    public static void main(String[] args) {
//        int source[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int result = binSearch(source, 9);
//        System.out.println(result);
        List<TestEntity> data = new ArrayList<TestEntity>();
        for (int i = 0; i < 10; i++) {
            TestEntity entity = new TestEntity();
            entity.setAge(i);
            data.add(entity);
        }
        TestEntity entity = new TestEntity();
        entity.setAge(11);
        data.add(entity);
        TestEntity entity1 = new TestEntity();
        entity1.setAge(14);
        data.add(entity1);

        TestEntity key = new TestEntity();
        key.setAge(11);


       int result =  BinartSearchUtils.bindSerch(data, key, new Condition<TestEntity>() {
            @Override
            public int compare(TestEntity array0, TestEntity array1) {
                return array0.getAge()-array1.getAge();
            }
        });
        System.out.println(result);
//        Collections.sort(data, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
    }

    /**
     * 查找数组中某个关键字的下标
     *
     * @param array
     * @param key
     * @return
     */
    public static int binSearch(int[] array, int key) {
        int start = 0;
        int mid;
        int end = array.length - 1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (key < array[mid]) {
                end = mid - 1;
            } else if (key > array[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }



}
