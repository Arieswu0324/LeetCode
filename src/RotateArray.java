public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] numsb = new int[nums.length];
        for(int i = 0; i< n; i++){
            numsb[(i+k)%n] = nums[i];
        }
        System.arraycopy(numsb, 0, nums, 0, n);
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 2};
        int k1 = 7;
        rotate(nums1, k1);
        System.out.println("Test Case 1: " + java.util.Arrays.toString(nums1));

        // Test case 2
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        rotate(nums2, k2);
        System.out.println("Test Case 2: " + java.util.Arrays.toString(nums2));

        // Test case 3
        int[] nums3 = {-1};
        int k3 = 2;
        rotate(nums3, k3);
        System.out.println("Test Case 3: " + java.util.Arrays.toString(nums3));
    }
}
