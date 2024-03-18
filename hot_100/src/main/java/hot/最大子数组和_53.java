package hot;

import java.util.ArrayList;
import java.util.Arrays;

public class 最大子数组和_53 {
    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 子数组是数组中的一个连续部分。
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
//        1.假如全是负数，那就是找最大值即可，因为负数肯定越加越大。
//        2.如果有正数，则肯定从正数开始计算和，不然前面有负值，和肯定变小了，所以从正数开始。
//        3.当和小于零时，这个区间就告一段落了，然后从下一个正数重新开始计算(也就是又回到 2 了)
        int max = nums[0];  // 初始化最大值
        int sum = 0; // 累加值
        for (int num : nums) {
//            因为只有正数累加才会越来越大
            if (sum > 0) {
                sum += num;
            } else {
//                不断寻找正数,进行赋值累加和
                sum = num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }


    public int maxSubArray_1(int[] nums) {
        int sum = 0;
        int ans = nums[0];
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }


    public static void main(String[] args) {
        最大子数组和_53 test = new 最大子数组和_53();
        int[] ints = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ints1 = test.maxSubArray_1(ints);
        System.out.println(ints1);

    }
}
