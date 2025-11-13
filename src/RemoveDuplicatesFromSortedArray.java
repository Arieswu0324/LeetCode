

/*
* Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.



Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).


Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
nums is sorted in non-decreasing order.
* */



public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int p1=0;
        int p2=1;
        while(p2<nums.length){
            if(nums[p1]!=nums[p2]){
                p1++;
                nums[p1]=nums[p2];
            }
            p2++;
        }
        return p1+1;//count should be index + 1
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 1, 2};
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        int k1 = solution.removeDuplicates(nums1);
        System.out.println("Test Case 1: k = " + k1 + ", nums = " + java.util.Arrays.toString(nums1));

        // Test case 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = solution.removeDuplicates(nums2);
        System.out.println("Test Case 2: k = " + k2 + ", nums = " + java.util.Arrays.toString(nums2));

        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 5};
        int k3 = solution.removeDuplicates(nums3);
        System.out.println("Test Case 3: k = " + k3 + ", nums = " + java.util.Arrays.toString(nums3));
    }
}
