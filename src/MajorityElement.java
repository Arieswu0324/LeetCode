import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int findMajority(int[] nums){
        int candidate = nums[0];
        int count = 0;
        for(int x: nums){
            if(count == 0){
                candidate = x;
                count=1;
            }else{
                if(candidate == x){
                    count++;
                }else{
                    count--;
                }
            }

        }
        return candidate;
    }


    public static void main(String[] args) {
        int[] nums1 = {6,5,5};
        System.out.println(findMajority(nums1)); // Output: 5

        int[] nums2 = {2,2,1,1,1,2,2};
        System.out.println(findMajority(nums2)); // Output: 2

        int[] nums3 = {1};
        System.out.println(findMajority(nums3));
    }
}
