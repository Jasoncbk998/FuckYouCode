import com.sun.org.apache.bcel.internal.generic.SWAP;

public class _31 {
    /**
     * 输入：nums = [1,2,3]
     * 输出：[1,3,2]
     * <p>
     * 输入：nums = [3,2,1]
     * 输出：[1,2,3]
     */
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] ints = {1, 2, 4, 9, 8, 7, 6, 1};
        nextPermutation(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + "\t");
        }
    }

}
