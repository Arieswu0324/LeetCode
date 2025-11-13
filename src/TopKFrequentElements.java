import java.util.*;

/**
 * Top K Frequent Element
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Example:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * */

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a,b)->(a.getValue()-b.getValue()));
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        map.entrySet().forEach(entry->{
            minHeap.add(entry);
            if(minHeap.size()>k){
                minHeap.remove();
            }
        });

      return minHeap.stream().mapToInt(Map.Entry::getKey).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2,3,1,3,2};
        System.out.println(Arrays.toString(topKFrequent(nums,2)));

        int[] nums1 = {1};
        System.out.println(Arrays.toString(topKFrequent(nums1, 1)));

        int[] nums2 = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums2, 2)));
    }
}
