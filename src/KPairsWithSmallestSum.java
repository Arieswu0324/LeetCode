import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithSmallestSum {


    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a, b) -> {
            int suma = a.getFirst() + a.getLast();
            int sumb = b.getFirst() + b.getLast();
            return sumb - suma;
        });

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                if (queue.size() < k) {
                    queue.add(List.of(nums1[i], nums2[j]));
                } else {
                    int head = queue.peek().getFirst() + queue.peek().getLast();
                    if (sum < head) {
                        queue.poll();
                        queue.add(List.of(nums1[i], nums2[j]));
                    }
                }
            }
        }

        return queue.stream().toList().reversed();
    }


    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }


        // 最小堆：存储 [i, j]
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) ->
                (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
        );

        // 初始化，先放一组下标，nums2的下标都为0
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            queue.add(new int[]{i, 0});
        }

        while (k-- > 0 && !queue.isEmpty()) {
            int[] head = queue.poll();
            int i = head[0];
            int j = head[1];
            res.add(List.of(nums1[i], nums2[j]));

            //多路并归
            if(j+1<nums2.length){
                queue.add(new int[]{i, j+1});
            }
        }
        return res;
    }
}
