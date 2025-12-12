package round2;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        TopKFrequent instance = new TopKFrequent();
        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(instance.topKFrequent(nums, 2)));
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        map.entrySet().forEach(entry -> {
            if (queue.size() < k) {
                queue.add(entry);
            } else {
                queue.add(entry);
                queue.remove();
            }
        });

       return queue.stream().map(Map.Entry::getKey).mapToInt(Integer::valueOf).toArray();
    }
}
