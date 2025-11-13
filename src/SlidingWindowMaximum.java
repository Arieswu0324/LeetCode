import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    static Deque<Integer> deque;

    public static int[] maxSlidingWindow(int[] nums, int k) {
        deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            push(nums[i]);
        }
        res[0] = getMaxValue();
        for (int i = 1; i < nums.length - k + 1; i++) {
            push(nums[i + k - 1]);
            pop(nums[i-1]);
            res[i] = getMaxValue();
        }
        return res;
    }

    private static void push(int val) {
        while (!deque.isEmpty() && deque.getLast() < val) {
            deque.removeLast();
        }
        deque.offerLast(val);

    }

    private static void pop(int val) {
        if (deque.getFirst() == val) {
            deque.removeFirst();
        }
    }

    private static int getMaxValue() {
        return deque.getFirst();
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums1 = {1};
        int[] nums2 = {-7,-8,7,5,7,1,6,0};
        //System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
        //System.out.println(Arrays.toString(maxSlidingWindow(nums1, 1)));
        System.out.println(Arrays.toString(maxSlidingWindow(nums2, 4)));
    }
}
