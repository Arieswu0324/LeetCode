public class RemoveElement {
    //相向双指针
    public static int removeElement(int[] nums, int val) {
        int head=0;
        int tail = nums.length-1;

        while(tail>=head){
            if(nums[head]==val){
                nums[head]=nums[tail];
                tail--;
            }
            else{
                head++;
            }
        }

        return head;
    }

    //快慢指针
    public static int removeElement2(int[] nums, int val){
        int fast = 0;
        int slow = 0;
        while(fast < nums.length){
            if(nums[fast] == val){
                fast++;
            }else{
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int k1 = removeElement2(nums1, val1);
        System.out.println("Test Case 1: k = " + k1 + ", nums = " + java.util.Arrays.toString(nums1));

        // Test case 2
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int k2 = removeElement2(nums2, val2);
        System.out.println("Test Case 2: k = " + k2 + ", nums = " + java.util.Arrays.toString(nums2));

        // Test case 3
        int[] nums3 = {4, 5};
        int val3 = 5;
        int k3 = removeElement2(nums3, val3);
        System.out.println("Test Case 3: k = " + k3 + ", nums = " + java.util.Arrays.toString(nums3));
    }

    }

