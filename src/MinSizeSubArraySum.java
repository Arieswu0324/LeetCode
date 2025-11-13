public class MinSizeSubArraySum {

    public static int minSubArraySum(int[] nums, int s) {
        int k = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        for(int j = 0; j < nums.length; j ++){
            sum = sum + nums[j];
            while (sum >= s){
                int len = j-i+1;
                k = Math.min(len, k);
                sum = sum - nums[i]; //先减去当前值，再移动
                i++;
            }
        }
        return k == Integer.MAX_VALUE? 0 : k;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int s1 = 7;
        System.out.println(minSubArraySum(nums1, s1));


        int[] nums2 = {1, 4, 4};
        int s2 = 4;
        System.out.println(minSubArraySum(nums2, s2));

        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int s3 = 11;
        System.out.println(minSubArraySum(nums3, s3));
    }
}
