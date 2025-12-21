package round2;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> sub = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int start) {
        res.add(new ArrayList<>(sub));
        if (start == nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            sub.add(nums[i]);
            backtracking(nums, i + 1);
            sub.removeLast();
        }
    }


}
