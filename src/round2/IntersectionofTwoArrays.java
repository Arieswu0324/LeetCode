package round2;

import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        for(int n: nums1){
            set.add(n);
        }


        for(int n : nums2){
            if(set.contains(n)){
                intersection.add(n);
            }
        }

       return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}
