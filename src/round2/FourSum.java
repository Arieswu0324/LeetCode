package round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//和ThreeSum应该差不多思路，双指针，不用哈希表，后者比较麻烦
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0 && nums[i] > target) {
                break;//剪枝
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;//去重
            }

            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] > target && nums[i] + nums[j] >= 0) {
                    break;
                }
                if (j > i+1 && nums[j] == nums[j - 1]) {
                    continue;//去重
                }

                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    //边界问题
                    if (nums[l] + nums[k] + nums[i] + nums[j] > target) {
                        l--;
                    } else if (nums[l] + nums[k] + nums[i] + nums[j]< target) {
                        k++;
                    } else {
                        res.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    }
                }
            }

        }
        return res;

    }
}
