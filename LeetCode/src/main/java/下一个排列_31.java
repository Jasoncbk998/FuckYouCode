import java.util.Arrays;

/**
 * 我们希望找到一种方法，能够找到一个大于当前序列的新序列，且变大的幅度尽可能小。具体地：
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 */
public class 下一个排列_31 {
    /**
     * 从右边找,找到第一个前位<后位的元素
     * 然后在右边的降序序列中,找到第一个大于该元素的值,进行交换,随后对该子序列进行升序排列
     * 基本思路
     * https://www.bilibili.com/video/BV1gA411p7Qo/?spm_id_from=333.337.search-card.all.click&vd_source=1abeaffdf7ae60d5e5fd119219c5edb9
     * 例子1: 7,6,5,4,3,2,1 => 倒置为升序即可
     * 例子2: 7,6,4,5,3,2,1 => 7,6,5,4,1,2,3
     * 从右边开始寻找第一个破坏升序的元素,然后与最大的升序元素进行交换,随后的升序元素进行升序排列
     * 例子3: 1,2,4,9,8,7,6,1 => 1,2,6,1,4,7,8,9,
     * 从右边开始找到,第一个破坏升序的元素4,然后在右边找到第一个比4大的元素也就是6,然后交换,随后升序
     */
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 从后往前寻找,第一个非升序的元素
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

    //    交换
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
        int[] ints = {1, 2, 4, 9, 8, 7, 6, 1};
        nextPermutation(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + "\t");
        }
    }
}
