package round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return res;

    }

    private void backtracking(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[start] < 0) {
                return;
            }
            //这里不是i>0是i>start
            if(i>0 && candidates[i]==candidates[i-1]){
                continue;
            }
            path.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i + 1);
            path.removeLast();
        }
    }
}
