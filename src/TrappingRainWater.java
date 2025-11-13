import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[stack.peek()]) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                  int cur= stack.pop();
                  if(stack.isEmpty()){
                      break;
                  }
                  int h = Math.min(height[i], height[stack.peek()]);
                  int w = i-stack.peek()-1;
                  res+=w*(h-height[cur]);
                }
                stack.push(i);
            } else {//<
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TrappingRainWater instance = new TrappingRainWater();
        int[] height ={4,2,0,3,2,5};
        System.out.println(instance.trap(height));
    }
}
