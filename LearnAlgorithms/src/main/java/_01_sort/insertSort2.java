package _01_sort;

/**
 * 类似于扑克牌的排序,抓牌,然后排序
 */
public class insertSort2<E extends Comparable<E>> extends Sort<E> {
    /**
     * 逆序对
     * 2,3,8,6,1
     * 逆序对: 2,1  3,1   8,1   8,6   6,1 共5个
     * 逆序对越多,插入排序的复杂度正相关
     * 最坏是n的平方
     * 最好是n
     * 越小到大 性能越好
     */
    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            E v = array[cur]; // 备份待插入元素
            // 我和我右边的比较,我小于右边的时候,我就往右边移动
            while (cur > 0 && cmp(v, array[cur - 1]) < 0) {
                // 不断向右边移动元素,给待插入元素腾出合适的位置,减少比较次数
                array[cur] = array[cur - 1];
                cur--;
            }
            array[cur] = v;
        }
    }
}
