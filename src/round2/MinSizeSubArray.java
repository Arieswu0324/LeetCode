package round2;

public class MinSizeSubArray {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1};
        MinSizeSubArray instance = new MinSizeSubArray();
        System.out.println(instance.minSubArrayLen(11, nums));
    }


    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;

        while (left < nums.length) {
            while (right < nums.length && sum < target) {
                sum += nums[right];
                right++;
            }

            if (sum < target) {
                break;
            }

            int len = right - left;
            res = Math.min(res, len);

            sum -= nums[left];
            left++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
