import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


    }


    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        return dp[prices.length - 1][4];

    }

    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][k * 2 + 1];

        for (int i = 1; i <= 2 * k - 1; i += 2) {
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k + 1; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j % 2 == 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }

        return dp[prices.length - 1][2 * k];

    }

}

