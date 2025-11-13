import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] newHeights = new int[len+2];
        for(int i = 0; i<len; i++){
            newHeights[i+1] = heights[i];
        }
        int res = 0;
        stack.push(0);
        for(int i = 1; i<len+2; i++){
            if(newHeights[i]<newHeights[stack.peek()]){
                while(!stack.isEmpty()&&newHeights[i]<newHeights[stack.peek()]){
                    int cur = stack.pop();
                   if(stack.isEmpty()){
                    break;
                   }
                    int w = i-stack.peek()-1;
                    int size = w*newHeights[cur];
                    res = Math.max(res, size);
                }
                stack.push(i);
            }else{
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LargestRectangleinHistogram instance = new LargestRectangleinHistogram();
        int[] heights = {2,1,5,6,2,3};
        System.out.println(instance.largestRectangleArea(heights));

    }
}
