public class 最长公共子序列_1143 {
    /**
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace" ，它的长度为 3
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        // 动态规划,两个string,相当于长和宽,中间的元素值就是长度
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                // 相等
                if (c1 == c2) {
                    //子序列长度+1
                    // 动态转移方程: dp[i][j]=记录dp[i-1][j-1]的长度
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 记录当前位置最大子序列长度
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
