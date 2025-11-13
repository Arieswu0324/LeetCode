import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> comb = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        backtracking(candidates,target, comb,0);
        return res;

    }

    private static void backtracking(int[] candidates, int target, List<Integer> comb, int index){
        if(target == 0){
            res.add(new ArrayList<>(comb));
            return;
        }

        for(int i = index; i< candidates.length; i++){
            target = target - candidates[i];
            if(target<0){
                target = target + candidates[i];
                continue;
            }
            comb.add(candidates[i]);
            backtracking(candidates, target, comb, i);
            comb.removeLast();
            target = target + candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        List<List<Integer>> res = combinationSum(candidates, 8);
        res.forEach(System.out::println);
    }
}
