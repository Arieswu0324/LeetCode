package round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> sub = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int start) {
        res.add(new ArrayList<>(sub));
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            sub.add(nums[i]);
            backtracking(nums, i + 1);
            sub.removeLast();
        }
    }
}
