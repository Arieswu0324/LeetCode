import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

        Map<Integer, Integer> map = IntStream.range(0, nums1.length)
                .boxed()
                .collect(Collectors.toMap(i -> nums1[i], i -> i));

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(nums2[0]);

        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= stack.peek()) {
                stack.push(nums2[i]);
            } else {
                while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                    if (map.containsKey(stack.peek())) {
                        int index = map.get(stack.peek());
                        res[index] = nums2[i];
                        stack.pop();
                    }else{
                        stack.pop();
                    }

                }
                stack.push(nums2[i]);
            }
        }
        return res;
    }
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(res, -1);

        for(int i = 0; i<length*2; i++){
            while(!stack.isEmpty()&&nums[i%length]>nums[stack.peek()]){
                    res[stack.peek()] = nums[i%length];
                    stack.pop();
                }
                stack.push(i%length);
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,3};
        NextGreaterElementI instance = new NextGreaterElementI();
        int[] res = instance.nextGreaterElements(nums);
        System.out.println(Arrays.toString(res));
    }
}
