package round2;

import java.util.HashMap;
import java.util.Map;

//暴力是N^4，空间换时间应该可以降到N^3
public class ForSumII {
    //N^3 不能全部AC，超时
    public int fourSumCount1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        int n = nums1.length;
        //value - index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int temp = nums1[i] + nums2[j] + nums3[k];
                    if (map.containsKey(temp)) {
                        map.put(temp, map.get(temp) + 1);
                    } else {
                        map.put(temp, 1);
                    }
                }
            }
        }

        for (int l = 0; l < n; l++) {
            if (map.containsKey(-nums4[l])) {
                res += map.get(-nums4[l]);
            }
        }

        return res;
    }

    //降到N^2，思路不变
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        int n = nums1.length;
        //value - index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = nums1[i] + nums2[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }

        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                int temp = nums3[k] + nums4[l];
                if (map.containsKey(-temp)) {
                    res += map.get(-temp);
                }
            }
        }

        return res;

    }
}
