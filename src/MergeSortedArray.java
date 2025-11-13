public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) {
            return;
        }

        //test case 3 Input: nums1 = [0], m = 0, nums2 = [1], n = 1
        int p = m + n - 1;
        while (n - 1 >= 0) {
            if (m - 1 >= 0 && nums2[n - 1] < nums1[m - 1]) {
                nums1[p] = nums1[m - 1];
                m--;
            } else {
                nums1[p] = nums2[n - 1];
                n--;
            }
            p--;
        }
    }

    public static void main(String[] args) {
        //test case 1
        System.out.println("Test Case 1:");
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        MergeSortedArray.merge(nums1, m, nums2, n);

        for (int num : nums1) {
            System.out.print(num + " ");
        }

        //test case 2 Input: nums1 = [1], m = 1, nums2 = [], n = 0
        System.out.println("\n Test Case 2:");
        nums1 = new int[]{1};
        m = 1;
        nums2 = new int[0];
        n = 0;
        MergeSortedArray.merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + " ");
        }

        //test case 3 Input: nums1 = [0], m = 0, nums2 = [1], n = 1
        System.out.println("\n Test Case 3:");
        nums1 = new int[]{0};
        m = 0;
        nums2 = new int[]{1};
        n = 1;
        MergeSortedArray.merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}


