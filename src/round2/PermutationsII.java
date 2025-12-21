package round2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> perm = new ArrayList<>();
    Set<Integer> indexSet = new HashSet<>();//深度

    public List<List<Integer>> permuteUnique(int[] nums) {
        backtracking(nums);
        return res;
    }

    private void backtracking(int[] nums) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexSet.contains(i)) {
                continue;
            }
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            indexSet.add(i);
            perm.add(nums[i]);
            backtracking(nums);
            indexSet.remove(i);
            perm.removeLast();
        }
    }
}
