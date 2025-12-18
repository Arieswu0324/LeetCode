package round2;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static void main(String[] args) {
        CombinationSumIII instant = new CombinationSumIII();
        List<List<Integer>> lists = instant.combinationSum3(3, 7);
        System.out.println(lists.size());
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, n, 1);
        return res;

    }

    private void backTracking(int k, int n, int start) {
        if (path.size() == k && n == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (n < 0) {
            return;
        }

        for (int i = start; i<= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            backTracking(k, n - i, i + 1);
            path.removeLast();

        }
    }
}
