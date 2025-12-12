package round2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMax {

    public static void main(String[] args) {
        SlidingWindowMax instance = new SlidingWindowMax();
        int[] nums = {3,1,1,3};
        System.out.println(Arrays.toString(instance.maxSlidingWindow(nums, 3)));
    }
    Deque<Integer> queue = new ArrayDeque<>();
    public int[] maxSlidingWindow(int[] nums, int k) {
       int[] res = new int[nums.length-k+1];

        for (int i = 0; i < k; i++) {
            push(nums[i]);
        }

        res[0] = findMax();
        for(int i = 1; i< nums.length-k+1; i++){
            push(nums[i+k-1]);
            pop(nums[i-1]);
            res[i] = findMax();
        }

        return res;
    }

    private void push(int x){
        //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
        //保证队列元素单调递减
        while (!queue.isEmpty() && queue.getLast() < x) {
            queue.removeLast();
        }
        queue.addLast(x);
    }

    private void pop(int x){
       if(queue.getFirst() == x){
           queue.removeFirst();
       }
    }

    private int findMax(){
        return queue.getFirst();
    }
}
