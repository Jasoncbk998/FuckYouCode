public class 下一个排列_31 {
    /**
     * 我们希望找到一种方法，能够找到一个大于当前序列的新序列，且变大的幅度尽可能小。具体地：
     * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
     * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
     * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
     */
    public static void nextPermutation(int[] nums) {
        // 4,6,5,3
        int i = nums.length - 2;
        // 寻找右边的较大数
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 存在较大数
        if (i >= 0) {
            int j = nums.length - 1;
            // 寻找最小数
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 较大数+1
        reverse(nums, i + 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] ints = {4,6,5,3};
        nextPermutation(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+"\t");
        }
    }
}
