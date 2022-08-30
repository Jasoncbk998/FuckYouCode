import java.util.PriorityQueue;

public class 买卖股票的最佳时机_121 {
    /**
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票
     */
    public static int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE; // 2147483647
        System.out.println(minprice);
        int maxprofit = 0;
        // 遍历每一天的股价
        for (int i = 0; i < prices.length; i++) {
            // 不断寻找最低价格
            if (prices[i] < minprice) {
                // 更新最低价格
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                // 依次用当前价格-最低价格 是否大于最大利润
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}