

/**
 * @description: 买股票的最佳时机
 * @author: 孙彬
 */
public class MaxProfit122 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        for (int i = 1;i < n;i++) {
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i-1];
        }
        return maxProfit;
    }
}
