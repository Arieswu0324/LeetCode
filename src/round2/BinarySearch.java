package round2;


//You must write an algorithm with O(log n) runtime complexity.
//[left, right)
public class BinarySearch {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length;
        int res = -1;

        if (nums[left] > target || nums[right - 1] < target) {
            return res;
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1; //左开
            } else if (nums[mid] > target) {
                right = mid;//右闭
            } else {
                res = mid;
                break;
            }

        }

        return res;
    }
}
