package hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 子数组是数组中元素的连续非空序列。
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 */
public class 和为K的子数组_560 {

    public int subarraySum(int[] nums, int k) {
        int  count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        和为K的子数组_560 test = new 和为K的子数组_560();
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(test.subarraySum(nums, k));
    }


}
