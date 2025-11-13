import java.util.HashMap;
import java.util.Map;

public class Sum4II {
    public static int sum4(int[] numsA, int[] numsB, int[] numsC, int[] numsD) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = numsA.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int s = numsA[i] + numsB[j];
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        for (int k = 0; k < len; k++) {
            for (int l = 0; l < len; l++) {
                int s = numsC[k] + numsD[l];
                if (map.containsKey(-s)) {
                    count += map.get(-s);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        System.out.println(sum4(nums1, nums2, nums3, nums4));
    }
}
