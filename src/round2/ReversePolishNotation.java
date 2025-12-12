package round2;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReversePolishNotation {
    //["2","1","+","3","*"]
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();

        for (String s : tokens) {
            if (stack.isEmpty()) {
                stack.push(s);
            } else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                stack.push(calculate(stack.pop(), stack.pop(), s));
            } else {
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private String calculate(String b, String a, String operand) {

        return switch (operand) {
            case "+" -> String.valueOf(Integer.parseInt(a) + Integer.parseInt(b));
            case "-" -> String.valueOf(Integer.parseInt(a) - Integer.parseInt(b));
            case "*" -> String.valueOf(Integer.parseInt(a) * Integer.parseInt(b));
            case "/" -> String.valueOf(Integer.parseInt(a) / Integer.parseInt(b));
            default -> "";
        };
    }
}
