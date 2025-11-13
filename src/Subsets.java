import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Subsets {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return res;
    }

    private void backtracking(int[] nums, int index){
        res.add(new ArrayList<>(subset));
        if(index == nums.length){
            return;
        }

        for(int i = index; i< nums.length; i++){
                subset.add(nums[i]);
                backtracking(nums, i+1);
                subset.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Subsets instance = new Subsets();
        List<List<Integer>> res = instance.subsets(nums);
        res.forEach(System.out::println);
    }

}
