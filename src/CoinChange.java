import java.util.Arrays;

public class CoinChange {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for(int i = 0; i< coins.length; i++){
            for(int j = 0; j<=amount; j++){
                if(j>=coins[i])
                {
                    dp[j] = dp[j] + dp[j-coins[i]];
                    //System.out.println(dp[j]);
                }
            }
        }
        return dp[amount];

    }

    public static void main(String[] args) {
        CoinChange instance = new CoinChange();
        int[] coins = {1,2,3};
        System.out.println(instance.change(4,coins));
    }
}
