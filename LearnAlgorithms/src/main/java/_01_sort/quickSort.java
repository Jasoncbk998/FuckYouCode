package _01_sort;

public class quickSort<E extends Comparable<E>> extends Sort<E> {
    /**
     * 基本思路
     * 从序列选择一个轴点元素,利用轴点将序列分割为两部分
     * 轴点元素左边的都比他小,轴点元素右边的元素都比他大
     * 本质就是所有的元素都变为轴点后,这个序列就有序了
     *
     * 最好情况,轴点元素两边数量近似
     * 所以要随机选择轴点元素
     */
    @Override
    protected void sort() {
        sort(0, array.length);
    }

    /**
     * 对 [begin,end)范围进行快排
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) return;
        // 确定轴点位置
        int mid = pivotIndex(begin, end);
        // 对子序列进行快速排序
        // 左边
        sort(begin, mid);
        // 右边
        sort(mid + 1, end);

    }

    // 确定[begin,end)中的轴点元素,返回轴点元素的最终位置
    private int pivotIndex(int begin, int end) {
        // 随机选一个元素和begin进行交换
        swap(begin, begin + (int)(Math.random() * (end - begin)));
        // 备份begin位置元素
        E pivot = array[begin];
        end--; // 因为是左闭右开
        while (begin < end) {
            while (begin < end) {  // 不能有等于号 ,这样破坏了均匀切割,导致了最坏情况出现
                if (cmp(pivot, array[end]) < 0) { // 右边元素>轴点元素
                    end--;
                } else { // 右边元素<=轴点元素
                    array[begin++] = array[end];
                    break;
                }
            }
            while (begin < end) {
                if (cmp(pivot, array[begin]) > 0) {
                    begin++;
                } else { // 左边元素>=轴点元素
                    array[end--] = array[begin];
                    break;
                }
            }
        }
        array[begin] = pivot;
        return begin; // begin=end 才会来到这里 确定轴点
    }
}
