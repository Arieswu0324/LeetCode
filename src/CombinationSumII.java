import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> comb = new ArrayList<>();
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtracking(candidates, target,0);
            return res;

    }

    private static void backtracking(int[] candidates, int target, int index){
        if(target == 0){
            res.add(new ArrayList<>(comb));
            return;
        }

        for(int i = index; i< candidates.length && target - candidates[i] >=0; i++){

            if ( i > index && candidates[i] == candidates[i - 1] ) {
                continue;
            }

            target = target - candidates[i];
            comb.add(candidates[i]);
            backtracking(candidates, target, i+1);
            comb.removeLast();
            target = target + candidates[i];
        }

    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        List<List<Integer>> res = combinationSum2(candidates, 8);
        res.forEach(System.out::println);
    }


}
