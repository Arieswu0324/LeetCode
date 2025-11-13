import java.util.Arrays;

public class SquaresOfASortedArray {
    public static int[] squares(int[] nums){
        int i = 0; int j = nums.length-1;
        int[] res = new int[nums.length];
        int k = j;
        while(i<=j){
            if(nums[i] * nums[i] <= nums[j] * nums[j]){
                res[k] = nums[j] * nums[j];
                j--;
            }else{
                res[k]= nums[i] * nums[i];
                i++;
            }
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(squares(nums)));

        int[] nums2 = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(squares(nums2)));
    }
}
