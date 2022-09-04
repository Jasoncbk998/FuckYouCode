package _01_sort;

/**
 * 使用二分查找在挪动法之上进行再优化
 */
public class insertSort3<E extends Comparable<E>> extends Sort<E> {
    /**
     * 二分查找,减少比较次数  只是减少了比较次数,但是时间复杂度还是没变化的 还是n方
     */
    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            E e = array[begin];
            // 插入位置
            int insertIndex = search(begin);
            // 开始移动 [insertIndex,begin) 范围内元素像右移动一位
            insert(begin, search(begin));
        }
    }

    // 具体执行挪动元素的逻辑
    private void insert(int source, int dest) {
        E e = array[source];
        for (int i = source; i > dest; i--) {
            array[i] = array[i - 1];
        }
        array[dest] = e;
    }

    // 找到index位置元素的插入位置
    private int search(int index) {
        E e = array[index];
        // 在0到index中找到index合适的插入位置
        int begin = 0;
        int end = index;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            // 比较
            if (cmp(e, array[mid]) < 0) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }

}
