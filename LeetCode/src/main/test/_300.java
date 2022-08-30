public class _300 {

    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int maxresult = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (dp[i] > dp[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxresult = Math.max(dp[i], maxresult);
        }
        return maxresult;


    }
}
