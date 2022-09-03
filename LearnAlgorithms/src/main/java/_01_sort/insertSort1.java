package _01_sort;

/**
 * 类似于扑克牌的排序,抓牌,然后排序
 */
public class insertSort1<E extends Comparable<E>> extends Sort<E> {
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
        // 这个是交换的思想,但是问题是交换次数太多了
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            // 当我小于别人时,我才交换,所以稳定
            // 1,3a,3b   只有3b小于3a 我才交换 ,所以稳定
            while (cur > 0 && cmp(cur, cur - 1) < 0) {
                swap(cur, cur - 1);
                cur--;
            }
        }
    }
}
