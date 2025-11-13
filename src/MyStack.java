import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {
    private  Queue<Integer> queue;
    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        int size = queue.size();
        size--;
        while(size>0){
            queue.add(queue.poll());
            size--;
        }
        return queue.poll();
    }

    public int top() {
       int res = pop();
       queue.add(res);
       return res;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
