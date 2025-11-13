import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
    Set<List<Integer>> set = new HashSet<>();
    List<Integer> sub = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] used = new int[nums.length];
        backTracking(nums, used);
        return set.stream().toList();
    }

    private void backTracking(int[] nums, int[] used){
        if(sub.size() == nums.length){
            set.add(new ArrayList(sub));
            return;
        }


        for(int i = 0 ; i< nums.length; i++){
            if(used[i] == 1){
                continue;
            }
            sub.add(nums[i]);
            used[i] = 1;
            backTracking(nums, used);
            sub.removeLast();
            used[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        PermutationsII instance = new PermutationsII();
        List<List<Integer>> res = instance.permuteUnique(nums);
        res.forEach(System.out::println);
    }
}
