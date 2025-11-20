import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        int[] h = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(trap(h));
    }

    public static int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int sum = 0;

        for (int i = 1; i < height.length; i++) {
            if ( height[i] > height[stack.peek()]) {
                while ( !stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int left = height[i];
                    int mid = height[stack.pop()];
                    if (stack.isEmpty()) {
                        break;
                    }
                    int right = height[stack.peek()];
                    int h = Math.min(left, right) - mid;
                    int w = i-stack.peek() - 1;
                    sum += h * w;
                }
                stack.push(i);
            } else {
                stack.push(i);
            }
        }
        return sum;
    }

}

