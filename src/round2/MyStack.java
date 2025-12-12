package round2;

import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {

    private int last;
    private final Queue<Integer> queueIn;
    private final Queue<Integer> queueOut;

    public MyStack() {
        last = 0;
        queueIn = new ArrayDeque<>();
        queueOut = new ArrayDeque<>();
    }

    public void push(int x) {
        queueIn.add(x);
    }

    public int pop() {
        last = queueIn.remove();
        while (!queueIn.isEmpty()) {
            queueOut.add(last);
            last = queueIn.remove();
        }

        while (!queueOut.isEmpty()) {
            queueIn.add(queueOut.remove());
        }

        return last;
    }

    public int top() {
        last = queueIn.remove();
        while (!queueIn.isEmpty()) {
            queueOut.add(last);
            last = queueIn.remove();
        }

        queueOut.add(last);

        while (!queueOut.isEmpty()) {
            queueIn.add(queueOut.remove());
        }

        return last;

    }

    public boolean empty() {
        return queueIn.isEmpty();
    }
}

