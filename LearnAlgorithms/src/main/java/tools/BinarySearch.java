package tools;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class BinarySearch {
    // 查找v在有序数组中的位置
    public static int indexOf(Integer[] array, int v) {
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (v < array[mid]) {
                end = mid;
            } else if (v > array[mid]) {
                begin = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 查找v在有序数组array中待插入的位置
     */
    public static int search(int[] array, int v) {
        // 找到第一个比v大的元素位置
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if(v<array[mid]){
                end=mid;
            } {
              // v>=array[mid]
                begin=mid+1;
            }
        }
        return begin; // 其实最终一定是begin=end 所以返回谁都可以


    }
}
