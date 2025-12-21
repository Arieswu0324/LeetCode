package round2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> perm = new ArrayList<>();
    Set<Integer> set = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums);
        return res;
    }

    private void backtracking(int[] nums) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            }
            set.add(num);
            perm.add(num);
            backtracking(nums);
            perm.removeLast();
            set.remove(num);
        }
    }
}
