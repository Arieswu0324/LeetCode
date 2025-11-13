import java.util.Arrays;

public class SumInterval {
    public static int sumInterval(int[] nums, int start, int end) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
        }
        System.out.println(Arrays.toString(sums));
        return start == 0 ? sums[end]
                : (sums[end] - sums[start - 1]); //求和是左闭右闭区间，包括start, end的值，所以要减去前一个下标对应的数字
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(sumInterval(nums, 0, 1));
        System.out.println(sumInterval(nums, 1, 3));
        System.out.println(sumInterval(nums,4,4));

    }
}
