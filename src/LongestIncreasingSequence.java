import java.util.Arrays;

public class LongestIncreasingSequence {


    public static int lengthOfLIS(int[] nums) {
        int res = Integer.MIN_VALUE;//这里最低是1，不能用最小值初始化
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public int length(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {//这里是不对的，这里是连续比较了，本题其实不是连续相等的两个元素的比较，而是范围内每一个元素的比较
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[nums.length - 1];

    }
}
