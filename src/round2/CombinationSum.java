package round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target,0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int nextTarget = target - candidates[i];
            if (nextTarget < 0) {
                break;
            }
            //2,3,6,7
            path.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i);
            path.removeLast();
        }
    }
}
