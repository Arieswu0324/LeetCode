package round2;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, 1, k);
        return res;
    }

    private void backtracking(int n, int start, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n-(k-path.size())+1; i++) {
            path.add(i);
            backtracking(n, i + 1, k);
            path.removeLast();
        }
    }
}
