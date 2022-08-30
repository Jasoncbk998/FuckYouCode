public class _70 {

    public int climbStairs(int n) {
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;
        //dp[3]=dp[2]+dp[1]=1+2=3
        //dp[4]=dp[3]+dp[2]=3+2=5
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }
}
