public class _121 {
    public static int maxProfit(int[] prices) {
        int minPrice = 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            // 最低价格
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

}
