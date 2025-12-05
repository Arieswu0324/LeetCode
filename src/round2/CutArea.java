package round2;

public class CutArea {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {2, 1, 3}, {1, 2, 3}};
        System.out.println(preSum(nums));
    }

    public static int minDiff(int[][] nums) {
        int sum = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int[] num : nums) {
            for (int j = 0; j < nums[0].length; j++) {
                sum += num[j];
            }
        }

        int temp = 0;
        //竖切
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                temp += nums[i][j];
            }
            int d = Math.abs(sum - temp - temp);
            minDiff = Math.min(d, minDiff);
        }

        temp = 0;
        //横切
        for (int j = 0; j < nums[0].length - 1; j++) {
            for (int i = 0; i < nums.length; i++) {
                temp += nums[i][j];
            }
            int d = Math.abs(sum - temp - temp);
            minDiff = Math.min(d, minDiff);
        }

        return minDiff;

    }

    public static int preSum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int min = Integer.MAX_VALUE;
        int[] horizontal = new int[m];
        int[] vertical = new int[n];
        int sum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += nums[i][j];
                horizontal[i] += nums[i][j];
                vertical[j] += nums[i][j];
            }
        }

        int hcut = 0;
        for (int i = 0; i < m-1; i++) {
            hcut += horizontal[i];
            min = Math.min(min, Math.abs(sum - 2 * hcut));
        }

        int vcut = 0;
        for (int j = 0; j < n-1; j++) {
            vcut += vertical[j];
            min = Math.min(min, Math.abs(sum - 2 * vcut));
        }

        return min;
    }
}
