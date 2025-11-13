import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];

        int m = (int) Math.sqrt(n);
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if(j>=i*i&&dp[j-i*i]!=Integer.MAX_VALUE ) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }

        return dp[n]==Integer.MAX_VALUE?n:dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares instance = new PerfectSquares();
        System.out.println(instance.numSquares(4));
    }
}
