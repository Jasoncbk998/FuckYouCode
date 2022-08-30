import java.beans.beancontext.BeanContext;
import java.util.Arrays;

public class _sort {

    public static void main(String[] args) {
        int[] nums = {3, 5, 4, 2, 1};

        int[] ints = insertSort(nums);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] quickSortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static int[] insertSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int max = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[max] <= arr[j]) {
                    max = j;
                }
            }
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    /**
     * 冒泡
     */
    public static int[] bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }

    /**
     * 快速排序
     */
    private static void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int left, right, x;
            left = l;
            right = r;
            x = nums[left]; // 先取
            while (left < right) {
                while (left < right && nums[right] > x) {
                    right--; // // 从右向左找第一个小于x的数
                }
                if (left < right) {
                    nums[left++] = nums[right];
                }
                while (left < right && nums[left] < x) {
                    left++; //  // 从左向右找第一个大于x的数
                }
                if (left < right) {
                    nums[right--] = nums[left];
                }
            }
            nums[left] = x;
            quickSort(nums, l, left - 1);
            quickSort(nums, left + 1, r);
        }


    }
}
