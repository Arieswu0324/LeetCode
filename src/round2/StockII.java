package round2;

public class StockII {
    public int maxProfit(int[] prices) {
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if (profit > 0) {
                max += profit;
            }
        }

        return max;

    }
}
