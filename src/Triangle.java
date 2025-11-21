import java.util.List;

public class Triangle {

    //dp[i][j] 表示从三角形顶部走到位置 (i,j) 的最小路径和。
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];
        dp[0][0] = triangle.getFirst().getFirst();

        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).getFirst();
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).getLast();
        }

        int res = dp[len - 1][0];
        for (int i = 1; i < len; i++) {
            res = Math.min(res, dp[len - 1][i]);
        }

        return res;
    }

    //dp[i] 表示以从上到第i层第i位的最短路径
    public int minimumTotal2(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len];
        dp[0] = triangle.getFirst().getFirst();

        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j] + triangle.get(i).get(j), dp[j-1]);
            }
            dp[0] += triangle.get(i).getFirst();
        }

        int minTotal = dp[0];
        for (int i = 1; i < len; ++i) {
            minTotal = Math.min(minTotal, dp[i]);
        }
        return minTotal;
    }
}
