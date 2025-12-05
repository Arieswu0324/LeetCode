package round2;

public class RemoveElement {

    //Input: nums = [0,1,2,2,3,0,4,2], val = 2
    //Output: 5, nums = [0,1,4,0,3,_,_,_]
    public int removeElement(int[] nums, int val) {

        int left = 0;
        int right = nums.length - 1;


        while (left <= right) {
            if (nums[left] == val) {
                while (left <= right && nums[right] == val) {
                    right--;
                }

                if (left > right) {
                    break;
                }
                nums[left] = nums[right];
                right--;
            }
            left++;
        }

        return left;
    }

    public int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }

        return left;
    }
}
