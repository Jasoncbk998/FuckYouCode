package _01_sort;

public class mergeSort<E extends Comparable<E>> extends Sort<E> {
    private E[] leftArray;

    @Override
    protected void sort() {
        leftArray = (E[]) new Comparable[array.length >> 1];
        sort(0, array.length);
    }

    private void sort(int begin, int end) {
        // 元素数量小于2 直接返回
        if (end - begin < 2) return;
        int mid = (begin + end) >> 1;
        // 左闭右开
        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);
    }

    // 对 [begin,mid) 和[mid,end) 范围的序列合并成为一个有序序列
    private void merge(int begin, int mid, int end) {
        // 左边
        int li = 0, le = mid - begin;
        // 右边
        int ri = mid, re = end;
        int ai = begin;
        // 备份左边数组
        for (int i = li; i < le; i++) {
            // 因为总begin开始,所以是begin+i,这是一个递归调用,一定要注意
            leftArray[i] = array[begin + i];
        }
        // 如果左边没有结束,就需要比对
        // 因为有两种情况,左边的提前结束和右边提前结束,都会停止比对,但是这个基础都是基于左边比对结束的情况下
        // 左边提前结束,直接复制右边
        // 右边提前结束,还是需要复制左边
        // 所以关键点还是左边是否结束
        while (li < le) {
            // 右边小于左边 就li++ 覆盖 这样就是稳定的,这样就是相对来说相等元素的相对位置没有变化
            // ri<re 是左右两边都结束比较的最后结果 不管是左边先结束还是右边先结束,当ri>=re时才是完整的结束
            if (ri < re && cmp(array[ri], leftArray[li]) < 0) {
                // 只有右边小于左边,才把右边的赋值过来,这样才保证稳定
                array[ai++] = array[ri++];
            } else {
                array[ai++] = leftArray[li++];
            }
        }
    }
}
