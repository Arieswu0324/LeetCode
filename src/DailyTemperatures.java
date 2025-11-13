import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for(int i = 1; i<temperatures.length; i++){
            if(temperatures[i]<=temperatures[stack.peek()]){
                stack.push(i);
            }else{
                while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    res[stack.peek()] = i-stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures instance = new DailyTemperatures();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] res = instance.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(res));
    }
}
