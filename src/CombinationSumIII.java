import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> comb = new ArrayList<>();
    public static List<List<Integer>> combine(int k, int n){
        backTracking(k,n, 1);
        return res;
    }

    private static void backTracking(int k, int n, int startIndex){
        if(comb.size() == k){
            if(n==0) {
                res.add(new ArrayList<>(comb));
            }
            return;
        }

        for(int i = startIndex; i<= 9 - (k - comb.size()) + 1; i++){
            n = n-i;
            if(n<0){
                return;
            }
            comb.add(i);
            backTracking(k,n,i+1);
            n = n+i;
            comb.removeLast();
        }
    }

    public static void main(String[] args) {
       List<List<Integer>> res = combine(3,7);
       res.forEach(System.out::println);
    }
}
