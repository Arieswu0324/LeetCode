import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {
    public static List<List<Integer>> sum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            //第一重剪枝
            if (nums[i] >= 0 && nums[i] > target) {
                break;//直接退出
            }
            //去重a
            if (i  > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                //第二重剪枝
                if (nums[i] + nums[j] > target && nums[i] + nums[j] >= 0) {
                    break;//跳到上个循环
                }
                //去重b
                if (j  > i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        res.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        //去重c
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        //去重d
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> lists = sum(nums, -294967296);
        lists.forEach(System.out::println);
    }
}
