package round2;

import java.util.*;

//和哈希表没啥关系？
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);//升序排列
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                break;//后面不可能出现合为0的情况
            }
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;//去重
            }
            int target = -nums[i];
            //双指针
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (nums[j] + nums[k] < target) {
                    j++;
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return res;
    }
}
