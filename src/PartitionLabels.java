import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int left= 0;
        int right = 0;
        int[] index = new int[26];

        for(int i = 0; i< s.length(); i++){
          index[s.charAt(i)-'a'] = i;
        }

        for(int i = 0; i< s.length(); i++){
            right = Math.max(index[s.charAt(i)-'a'],right);
            if(right == i){
                res.add(right - left +1);
                left = i;
            }
        }
        return res;
    }
}
