package round2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//因为不能排序，所以去重就不能用相邻两个元素相等来处理，而是用每层用一个set
public class NonDecreasingSub {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> sub = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int start) {
        if (sub.size() > 1) {
            res.add(new ArrayList<>(sub));
        }

        if (start == nums.length) {
            return;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i]) || (sub.size() > 1 && nums[i] < sub.getLast())) {
                continue;
            }
            set.add(nums[i]);
            sub.add(nums[i]);
            backtracking(nums, i + 1);
            sub.removeLast();

        }
    }

    public static void main(String[] args) {
        NonDecreasingSub instance = new NonDecreasingSub();
        int[] nums = {4, 4, 3, 2, 1};
        System.out.println(instance.findSubsequences(nums).size());
    }

}
