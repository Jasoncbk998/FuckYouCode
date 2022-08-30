public class 零钱兑换_322 {
    /**
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * amount 是金额
     * coins是硬币数值
     * 用这些硬币凑成对应金额需要用最少硬币的个数
     * https://leetcode.cn/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
     */
    /**
     * 举一个例子
     * coins = [1, 2, 5], amount = 6
     * 有硬币面值1,2,3  需要凑够6这个数字
     * 金额     硬币数量
     * F(0) =  0
     * F(1) =  1 // F(1)=min(F(1-1),F(1-2),F(1-5))+1 = min(F(0))+1=1
     * F(2) =  1 // F(2)=min(F(2-1),F(2-2),F(2-5))+1 = min(F(1),F(0))+1=min(0,1)+1=1
     * F(3) =  2 // F(3)=min(F(3-1),F(3-2),F(3-5))+1 = min(F(2),F(1))+1=min(1,1)+1=2
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        //coins = [1, 2, 5], amount = 11
        // dp[i]=A 代表了 凑够I金额需要A个硬币
        // 可以把这个理解为全量枚举   amount,最多循环amont次 amount次1元的硬币
        for (int i = 1; i <= amount; i++) {
            // 遍历硬币
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    // dp[i - coins[j]] : dp[金额-硬币面值]
                    // dp[i] 代表了i金额需要最少的硬币数量
                    dp[i] = Math.max(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}