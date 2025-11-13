import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i< nums.length; i++){
            if(!map.containsKey(target-nums[i])){
                map.put(nums[i], i);
            }else {
                return new int[]{i,map.get(target-nums[i])};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        System.out.println(Arrays.toString(twoSum(nums,6)));
    }
}
