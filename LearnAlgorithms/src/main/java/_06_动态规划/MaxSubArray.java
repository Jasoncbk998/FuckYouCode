package _06_动态规划;

public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // dp[i] 以nums[i]结尾的最大连续子序列和
        int dp = nums[0];
        int max = dp; // 默认最大值是nums[0]

        for (int i = 1; i < nums.length; i++) {
            if (dp <= 0) {
                // 负数就不考虑相加了,越加越小
                dp = nums[i];
            } else {
                //更新当前i位的最大连续子序列和
                dp = dp + nums[i];
            }
            // 比较最大子序列和
            max = Math.max(dp, max);
            System.out.println("dp[" + i + "]= " + dp);
            // 可以理解为不断的更新dp这个值
        }
        return max;
    }

    static int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            int prev = dp[i - 1];
            if (prev <= 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = prev + nums[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
