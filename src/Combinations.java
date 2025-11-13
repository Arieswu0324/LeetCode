import java.util.ArrayList;
import java.util.List;

public class Combinations {
    static List<List<Integer>> res= new ArrayList<>();
    static List<Integer> combo = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return res;
    }

    private static void backtracking(int n, int k, int startIndex){
        if(combo.size() == k){
            res.add(new ArrayList<>(combo));
            //这里如果直接用res.add(combo)，此时加的是combo的引用地址，后面的撤回操作对这里是有影响的，因此需要new新的对象添加
            return;
        }

        for(int i = startIndex; i<=n; i++){
            combo.add(i);
            backtracking(n, k, i+1);
            combo.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        combine.forEach(System.out::println);
    }
}
