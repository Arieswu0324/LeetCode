import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class SumRootToLeaf {

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        SumRootToLeaf instance = new SumRootToLeaf();
        List<List<Integer>> res = instance.combinationSum(nums, 7);
        System.out.println(res.size());
    }


    List<List<Integer>> list = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return list;

    }

    public void backtracking(int[] nums, int target, int start) {
        if (target == 0) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (target - nums[i] < 0) {
                return;
            }
            path.add(nums[i]);
            backtracking(nums, target - nums[i], i);
            path.removeLast();
        }

    }

}
