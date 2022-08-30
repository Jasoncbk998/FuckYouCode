public class sort_归并排序 {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        mergeSort(nums);
        System.out.println(nums);
    }

    /**
     *
     */
    public static int[] mergeSort(int[] arr) {
        sort(0, arr.length);
        return arr;
    }

    /**
     * 对[begin,end)范围内的数据归并排序
     */
    private static void sort(int begin, int end) {
        if (end - begin < 2) return;
        int mid = (begin + end) >> 1;
        // 左闭右开
        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);
    }

    /**
     * 将[begin,mid) 和[mid,end)合并成为一个有序序列
     * 也是双指针思想,分别在两个数组的最左边开始找
     */
    private static void merge(int begin, int mid, int end) {
//        int li = 0, le = mid - begin;
//        int ri = mid, re = end;
//        int ai = 0;
//        for (int i = li; i < li; i++) {
//            leftArray[i]=array[begin+i];
//        }


    }


}
