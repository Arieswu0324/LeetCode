public class BinarySearch {
    public static int binarySearch1(int[] nums, int target) {
        //closed interval [left, right]

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;

    }

    public static int binarySearch2(int[] nums, int target) {
        //half-open interval [left, right)
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 3;
        System.out.println(binarySearch1(nums1, target1));
        System.out.println(binarySearch2(nums1, target1));
    }
}
