/*
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

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

Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).


Constraints:

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
* */


public class RemoveDuplicatesFromSortedArrayII {
    public static  int removeDuplicates(int[] nums) {
        // 1,1,1,2,2,3
        int p1=2; //新数组的指针，指向的当前位置，是需要被覆盖的位置
        int p2=2; //检查的值，在原数组中检查合适的值
        while(p2<nums.length){
            if(nums[p1-2]!=nums[p2]){//说明P2的值是可用的
                    nums[p1]=nums[p2]; //将P2检查的值赋给P1
                p1++;//p1移动
                p2++;//p2的值已经使用过了，移动
            }else{
                p2++;//否则，说明P1的这个位置，指向的值说明当前P1值相同，P2值不可用，p2继续移动，寻找下一个可用值
            }

        }
        return p1;

    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = removeDuplicates(nums1);
        System.out.println("Test Case 1: k = " + k1 + ", nums = " + java.util.Arrays.toString(nums1));

        // Test case 2
        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int k2 = removeDuplicates(nums2);
        System.out.println("Test Case 2: k = " + k2 + ", nums = " + java.util.Arrays.toString(nums2));

        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 5};
        int k3 = removeDuplicates(nums3);
        System.out.println("Test Case 3: k = " + k3 + ", nums = " + java.util.Arrays.toString(nums3));
    }
}
