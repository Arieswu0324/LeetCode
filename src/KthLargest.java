import java.util.PriorityQueue;

public class KthLargest {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }

    public static int findKthLargest(int[] nums, int k) {

        //默认小顶堆，从小到大
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                queue.add(nums[i]);
            } else {
                if (nums[i] < queue.peek()) {
                    continue;
                } else {
                    //head of the queue
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        return queue.peek();

    }


}
