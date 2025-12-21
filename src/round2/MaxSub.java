package round2;

import java.util.Arrays;

public class MaxSub {
    public static void main(String[] args) {
        MaxSub instance = new MaxSub();
        int[] nums = {-2, 5, 0, 2, -2};
        System.out.println(instance.largestSumAfterKNegations(nums, 3));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }

            sum += nums[i];
        }

        if (k % 2 == 1) {
            Arrays.sort(nums);
            sum -= 2 * nums[0];
        }

        return sum;
    }

//增强 for 循环（Enhanced For-Loop）在处理基本数据类型数组时，是“只读”的
    public int largestSumAfterKNegations2(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;

        for (int n : nums) {
            if (n < 0 && k > 0) {
                n = -n;
                k--;
            }

            sum += n;
        }

        if (k % 2 == 1) {
            Arrays.sort(nums);
            sum -= 2 * nums[0];
        }

        return sum;
    }
}
